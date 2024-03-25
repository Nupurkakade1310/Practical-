public class Main {

public static void main(String[] args) {

/*anonymous class = an inner class without a name

only a single object is created from one

The object may have "extras" or

"changes" and no need to create a separate innerclass

when it is only need it once.

Helps us to avoid cluttering code with a class name

Syntax is similar to a constructor, except that there is also a class definition

within a block of code.
GREAT FOR LISTENERS

*/

MyFrame myFrame = new MyFrame();

}

}

*

**

import java.awt.event.*;

import javax.swing.*;

public class MyFrame extends JFrame{

JButton button1 = new JButton("Button #1");

JButton button2 = new JButton("Button #2");

JButton button3 = new JButton("Button #3");

MyFrame(){
button1.setBounds (100,100,100,100); button2.setBounds(200,100,100,100); button3.setBounds (300,100,100,100); button1.addActionListener(new ActionListener() {

@Override

public void actionPerformed(ActionEvent e) {

System.out.println("You pressed button #1");

}

});

button2.addActionListener(new ActionListener() {

@Override

public void actionPerformed(ActionEvent e)
System.out.println("You pressed button #3");

}

});

this.add(button1);