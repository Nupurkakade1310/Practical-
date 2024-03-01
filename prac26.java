double weight; // weight of box

// constructor for BoxWeight

BoxWeight (double w, double h, double d, double m) {

width = W;

height = h;

depth = d;

weight = m;

}

}

class DemoBoxWeight {

public static void main(String args[]) {

BoxWeight mybox1 = new BoxWeight (10, 20, 15, 34.3);

BoxWeight mybox2 = new BoxWeight (2, 3, 4, 0.076);

double vol;

vol = myboxl.volume();

System.out.println("Volume of myboxl is + vol);

System.out.println("Weight of myboxl is 11 + mybox1.weight);

System.out.println();

vol = mybox2.volume ();

System.out.println("Volume of mybox2 is 11 + vol);

}

System.out.println("Weight of mybox2 is 11 + mybox2.weight);

}
vaTest (1, 2, 3); // OK

vaTest (true, false, false); // OK

vaTest(); // Error: Ambiguous! 

}

}