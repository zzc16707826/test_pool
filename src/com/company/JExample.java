package com.company;

import com.ericsson.otp.erlang.*;
//import com.sun.org.apache.xpath.internal.operations.String;

/**
 * Created by Administrator on 2017/5/13 0013.
 * java 模拟成一个node与erlang通信
 */
public class JExample {
    //测试用例入口
    static void main(String[] args) {
        try {
            JExample javaNode = new JExample("myJavaNode@192.168.2.160", "myNamedMbox", "abc");
            javaNode.process();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private OtpNode node;
    private OtpMbox mbox;

    public JExample(String nodeName, String mboxName, String cookie)
            throws Exception {
        super();
        node = new OtpNode(nodeName, cookie);
        mbox = node.createMbox(mboxName);
//        String Names[] = this.node.getNames();
        System.out.println("name:{" + mboxName + "," + nodeName + "}");
    }

    /**
     * 接收消息并处理
     */
    public void process() {
        while (true) {
            try {
                OtpErlangObject msg = this.mbox.receive();
                OtpErlangTuple t = (OtpErlangTuple) msg;
                OtpErlangPid from = (OtpErlangPid) t.elementAt(0);
                String name = ((OtpErlangString) t.elementAt(1)).stringValue();
                String greeting = "Greetings from Java, " + name + "!";
                OtpErlangString replyStr = new OtpErlangString(greeting);
                OtpErlangTuple outMsg = new OtpErlangTuple(new OtpErlangObject[]{this.mbox.self(), replyStr});
                this.mbox.send(from, outMsg);
            } catch (Exception E) {
                System.out.print("error " + E);
            }
        }
    }
}



//       while (true){
//           try{
//               OtpNode node = new OtpNode("myJavaNode", "abc");
//               OtpMbox named_mbox = node.createMbox("myNamedMbox");
//               OtpMbox anon_mbox = node.createMbox();
//               OtpErlangAtom anAtom = new OtpErlangAtom("some_atom");
//               OtpErlangString aString = new OtpErlangString("some_string");
//               OtpErlangInt anInt = new OtpErlangInt(22);
//               OtpErlangTuple aTuple = new OtpErlangTuple(new OtpErlangObject[]{anAtom, aString, anInt});
//               named_mbox.send("myNamedMbox", aTuple);
//               OtpErlangObject msg = named_mbox.receive();
//               OtpErlangTuple t = (OtpErlangTuple) msg;
//               String theAtom = ((OtpErlangAtom) t.elementAt(0)).atomValue();
//
//           }
//           catch (Exception e){
//               System.out.println("err:"+e);
//           }
//       };