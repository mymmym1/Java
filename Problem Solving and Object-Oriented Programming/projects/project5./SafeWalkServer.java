/**
 * Project 5
 * @author Yimin Miao, login miao28, labsec L11
 * @author Shawn Howe, login howes, labsec L11
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SafeWalkServer extends ServerSocket implements Runnable {
    ServerSocket serverSocket;
    Socket client;
    ArrayList<Socket> pendingRequests = new ArrayList<Socket>();
	
    ArrayList<String> requestMsgs = new ArrayList<String>(); // messages!!
    ArrayList<PrintWriter> printWrite = new ArrayList<PrintWriter>();
	
    private static final String[] LOC = { "CL50", "EE", "LWSN", "PMU", "PUSH" };
	/**
	 * Construct the server, and create a server socket, bound to the specified
	 * port.
	 *
	 * @throws IOException
	 *             IO error when opening the socket.
	 */
    public SafeWalkServer(int port) throws IOException {        
	super(port);
	setReuseAddress(true);  
    }    
	/**
	 * Construct the server, and create a server socket, bound to a port that is
	 * automatically allocated.
	 *
	 * @throws IOException
	 *             IO error when opening the socket.
	 */
    public SafeWalkServer() throws IOException {        
	this(0); //Using 0 can let the system assign a free port 
	setReuseAddress(true);
	System.out.println("Port not specified. Using free port " + this.getLocalPort() + ".");
    }    
	/**
	 * Start a loop to accept incoming connections. Note that your server should
	 * not start accepting incoming requests before run() is called.
	 */
    public void run() {
	try {
	    while (true) {  // To make the server run forever
		client = accept();  // pendingRequests.add(client);
		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);  // printWrite.add(out);
		String input = in.readLine();  // requestMsgs.add(input);				
		String inputCut = input.split(",", 2)[0];
		switch (inputCut) {
		    case ":RESET":                 	
		        out.println("RESPONSE: success");
		        for (PrintWriter p: printWrite)
			    p.println("ERROR: connection reset");
		        for (Socket pendSocket: pendingRequests)  
			    pendSocket.close();
			    pendingRequests.clear();
			    requestMsgs.clear();  
			    client.close();
			    break;
		    case ":SHUTDOWN": 
			out.println("RESPONSE: success");
			for (PrintWriter p: printWrite)
			    p.println("ERROR: connection reset");           	                                 	
			for (Socket pendSocket : pendingRequests)                          	
			    pendSocket.close();                        
			    pendingRequests.clear();
			    requestMsgs.clear();
			    client.close();
			    super.close();  // Shut down the server?
			    // System.out.println("Server is closed");
			    // break;
			    return;
		    case ":PENDING_REQUESTS":
		        int numcomma = 0;
		        for (int i = 0; i < input.length(); i++) 
			    if (input.charAt(i) == ',') 
			        numcomma++;
			if (numcomma != 3) { 
		            out.println("ERROR: invalid command");
			    client.close();
			    break;
			}
		        else {
			    String[] reqCmdparts = input.split(",", 4);
			    String task = reqCmdparts[1];
			    String reqfrom = reqCmdparts[2];
			    String reqto = reqCmdparts[3];
			    if (task.equals("*") && reqfrom.equals("*") && reqto.equals("*")) {
				if (requestMsgs.size() == 0) 
				    out.print("[ ]");  // didn't print out "[ ]"???
				else {  // (requestMsgs.size() > 0)                          
				    out.print("[");
				    for (int i = 0; i < requestMsgs.size() - 1; i++)
				    	out.print("[" + requestMsgs.get(i).split(",", 3)[0] + ", " 
				    	              + requestMsgs.get(i).split(",", 3)[1] + ", "
				    		      + requestMsgs.get(i).split(",", 3)[2]
				    		      + "], ");
				    	out.println("[" + requestMsgs.get(requestMsgs.size() - 1).split(",", 3)[0] + ", " 
				    	                + requestMsgs.get(requestMsgs.size() - 1).split(",", 3)[1] + ", " 
				    			+ requestMsgs.get(requestMsgs.size() - 1).split(",", 3)[2]  
				    			+ "]]");
				} 
		            }   					
			    else if (task.equals("#") && locMatch(reqfrom) && reqto.equals("*")) {  // total number of pending requests starting at FROM
				int count = 0;
				for (String msg: requestMsgs) {
				    String from = msg.split(",", 3)[1];
				    if (from.equals(reqfrom))
				    	count++;
				}
				out.println("RESPONSE: # of pending requests from " + reqfrom + " = " + count);
			    } 
			    else if (task.equals("#") && reqfrom.equals("*") && locMatch(reqto)) {  // total number of pending requests destined to TO
				int count = 0;
				for (String msg: requestMsgs) {
				    String to = msg.split(",", 3)[2];
				    if (to.equals(reqto))
				    	count++;
				}
				out.println("RESPONSE: # of pending requests to " + reqto + " = " + count);  
			    } 
			    else if (task.equals("#") &&  reqfrom.equals("*") && reqto.equals("*"))  
				out.println("RESPONSE: # of pending requests = " + requestMsgs.size());  // total  number of pending  requests
			    else 
				out.println("ERROR: invalid command");  // Make sure this will be printed out!!!
			    client.close();
			    break;
			}
		    default :	
		        if (input.charAt(0) == ':') {
			    out.println("ERROR: invalid command"); 
			    client.close(); 
		            break;
			}
			else {
			    int numcomma1 = 0;
			    for (int i = 0; i < input.length(); i++) 
				if (input.charAt(i) == ',') 
				    numcomma1++;
			    if (numcomma1 != 2) { 
				out.println("ERROR: invalid request");
				client.close();
				break;
			    }
			    else {
				String[] reqMsgparts = input.split(",", 3);
				String reqMsgname = reqMsgparts[0];
				String reqMsgfrom = reqMsgparts[1];
				String reqMsgto = reqMsgparts[2];
				// System.out.println(reqMsgname + " " + reqMsgfrom +"-->" + reqMsgto);
				if (locMatch(reqMsgfrom) && !(reqMsgfrom.equals(reqMsgto)) && (locMatch(reqMsgto) || reqMsgto.equals("*"))) {
				    if (requestMsgs.size() == 0) {
					pendingRequests.add(client);
					// System.out.println("client is added into the pending list");
					requestMsgs.add(input);
					// System.out.println(input + " msg is added into pending");
					printWrite.add(out);
					// System.out.println( "output is added into pending printWriter");
				    }
				    else {  // requestMsgs.size() > 0
					boolean matched = false;
					for (int i = 0; i < requestMsgs.size(); i++) {
					    String pendmsg = requestMsgs.get(i);
					    String from = pendmsg.split(",", 3)[1];
					    String to = pendmsg.split(",", 3)[2];
					    if (from.equals(reqMsgfrom) && (to.equals(reqMsgto) || reqMsgto.equals("*") || to.equals("*"))) {
						if (reqMsgto.equals("*") && to.equals("*"))
						    out.println("ERROR: invalid request");
						else { // match
						    matched = true;  
						    // System.out.println("Matches!");
						    out.println("RESPONSE: " + pendmsg);
						    int ind = requestMsgs.indexOf(pendmsg);
						    Socket matchSocket = pendingRequests.get(ind);
						    PrintWriter matchout = printWrite.get(ind);
						    matchout.println("RESPONSE: " + input);
						    matchSocket.close();
						    pendingRequests.remove(matchSocket);  
						    requestMsgs.remove(pendmsg);
						    printWrite.remove(matchout);
						    client.close();
						    break;
						}
					    }
					}    
					if (!matched) { // hold
					    pendingRequests.add(client);
			                    // System.out.println("client is added into the pending list");
					    requestMsgs.add(input);
	                                    // System.out.println(input + " msg is added into pending");
					    printWrite.add(out);
			                    // System.out.println( "output is added into pending printWriter");
					}
				    }
				}							
				else {
				    out.println("ERROR: invalid request");  //make sure this will work!!
				    client.close();
				    break;
				}						    							
			    }
			}
		}	
	    }
	} 
	catch (IOException e) {
	    System.out.println("exception happens");
	    e.printStackTrace();
	} 
	finally {
	    try {
		// System.out.println("Now in finally, client is going to be closed.");
		client.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

	/**
	 * Return true if the port entered by the user is valid. Else return false.
	 * Return false if you get a NumberFormatException while parsing the
	 * parameter port Call this method from main() before creating
	 * SafeWalkServer object Note that you do not have to check for validity of
	 * automatically assigned port
	 */
    public static boolean isPortValid(String port) {
		// TODO: finish this method
	int portnum;
	try {
	    portnum = Integer.parseInt(port);
	} catch (NumberFormatException e) {
	    return false;
	}
	if (portnum >= 1025 && portnum <= 65535) {
	    try {
		ServerSocket s = new ServerSocket(portnum);
		s.close();
		return true;
	    } catch (IOException e) {
		System.out.println("This port is not available!");
		return false;
	    }
	} 
	else
	    System.out.println("This port is not available!");
	return false;
    }
	
    public boolean locMatch(String place) {
	// System.out.print("Im in locMatch");
	for (int i = 0; i < 5; i++) {
	    if (place.equals(LOC[i]))
		return true;
	}	
	return false;
    }
	
    public static void main(String[] args) {
	if (args.length >= 1) {
	    String portstr = args[0];
	    SafeWalkServer skyWalker = null;
	    if (portstr == null) {
		try {
		    skyWalker = new SafeWalkServer();
		} catch (IOException e) {
		    System.out.println("ERROR: cannot create a SafeWalkServer!");
		}
	    } 
	    else if (SafeWalkServer.isPortValid(portstr)) {
		try {
		    skyWalker = new SafeWalkServer(Integer.parseInt(portstr));
		} catch (IOException e) {
		    System.out.println("ERROR: cannot create a SafeWalkServer!");
		}
	    }
	    Thread thread = new Thread(skyWalker);
	    thread.start();
	}
		/*
		 * Here a else block is needed, for the case that the port is not specified.
		 * In this case, the constructor SafeWalkServer() is used. 
		 */
	else {
	    try {
		SafeWalkServer skyWalker = new SafeWalkServer();
		Thread thread = new Thread(skyWalker);
		thread.start();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
}
