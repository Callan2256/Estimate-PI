import java.util.ArrayList;

public class est_pi {


    ArrayList<circlePoint> interior = new ArrayList<circlePoint>();
    ArrayList<circlePoint> exterior = new ArrayList<circlePoint>();

    public static void main(String[] args) {

            if (args.length < 1) {
                System.out.println("Please Enter Integer Argument");
                return;
            }

            int num = 0;
            try {
                num = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer value");
                System.out.println(e);
                return;
            }
            
            est_pi inst = new est_pi();
            inst.calculate_pi(num);
    }

   

    public void calculate_pi(int num) {
        double total_points = (double)num;
        double points_in_circle = 0;

        for (int n = 0; n <= num; n++) {
            circlePoint p = new circlePoint(Math.random(), Math.random());
            double dst = Math.pow(p.x, 2) + Math.pow(p.y, 2);

            if (dst <= 1) {
                points_in_circle += 1;
                this.interior.add(p);
            } else if (dst > 1)  {
                this.exterior.add(p);
            }
        }

        double pi = 4 * points_in_circle / total_points;

        System.out.println("-------------------------------------");
        System.out.println("Total Number of Points: " + (int)total_points);
        System.out.println("Points in circle: " + (int)points_in_circle);
        System.out.println("\nCalculation: 4 * " + (int)points_in_circle + " / " + (int)total_points);
        System.out.println("\nPi Estimation: " + pi);
        System.out.println("-------------------------------------");

        new plot_gui(this.interior, this.exterior);
    }

    //Init
    public est_pi () {}
}