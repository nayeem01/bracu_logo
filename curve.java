package Logo;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

class test implements GLEventListener {
    /**
     * Interface to the GLU library.
     */
    private GLU glu;

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable gld) {
        GL2 gl = gld.getGL().getGL2();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);
    }

    /**
     * Take care of drawing here.
     */

    void adc(GL2 gl,int x,int y){
       // gl.glPointSize(2);
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2f(x, y);
        gl.glEnd();
    }


    public void circle (GL2 gl, int r ){

        int x = r, y = 0, d = -4 * r + 5;
        draw8Way(gl, x, y);
        while (y <= x) {
            if (d < 0) {
                d = d + ((2 * y + 3) * 4);
                y++;
            } else {
                d += ((-2 * x + 2 * y + 5) * 4);
                x--;
                y++;
            }
            draw8Way(gl, x, y);
        }
    }
    void draw8Way(GL2 gl, int x, int y) {
        gl.glPointSize(5);
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glVertex2d(y, x);

        //gl.glVertex2d(-x, y);
        //gl.glVertex2d(-y, x);

       // gl.glVertex2d(-x, -y);
        // gl.glVertex2d(-y, -x);


        gl.glVertex2d(x, -y);
         gl.glVertex2d(y, -x);
        gl.glEnd();

    }
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
      //  gl.glClearColor( 1, 1, 1, 1);
//        double x=0,y=0;
//        gl.glBegin(GL2.GL_POINTS);
//        for(int i=0; i<80; i++) {
//            x= x + .1;
//            //y= Math.sqrt(x*5);
//            y= Math.pow(x,2);
//            //y= 1 /x ;
//            gl.glVertex2d(x, -y);
//        }
//      //  gl.glVertex2f(50, 50);
//        gl.glEnd();

        gl.glPushMatrix();
        gl.glTranslated(0, 0, 0);
        circle(gl, 20);
        gl.glPopMatrix();
//        gl.glPushMatrix();
//        gl.glTranslated(0, 40, 0);
//        circle(gl, 20);
//        gl.glPopMatrix();
//        gl.glPushMatrix();
//        gl.glTranslated(-3, -22, 0);
//        gl.glLineWidth(5);
//        gl.glBegin(GL2.GL_LINES);
//        gl.glVertex2d(0,0);
//        gl.glVertex2d(0,82);
//        gl.glEnd();
//        gl.glPopMatrix();

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
    }

    public void displayChanged(GLAutoDrawable drawable,
                               boolean modeChanged, boolean deviceChanged) {
    }

    public void dispose(GLAutoDrawable arg0)
    {

    }
}
public class curve
{
    public static void main(String args[])
    {
        //getting the capabilities object of GL2 profile
        final GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        // The canvas
        final GLCanvas glcanvas=new GLCanvas(capabilities);
        test b=new test();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame=new JFrame("Basic frame");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(640,480);
        frame.setVisible(true);
    }
}