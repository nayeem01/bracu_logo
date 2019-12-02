package Logo;
// ref graph https://www.transum.org/Maths/Activity/Graph/Desmos.asp
import com.jogamp.opengl.*;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import java.lang.Math;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
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
public static int range=78;
    void curve_zone1(GL2 gl){

        double x = 0,y = 0;
        gl.glBegin(GL2.GL_POINTS);
        for(int i=0; i<range; i++) {
            x= x + 1;
            y= Math.sqrt(x*20);
            gl.glVertex2d(x, y);
        }

        gl.glEnd();
    }
    void curve_zone2(GL2 gl){
        double x = 0,y = 0;
        gl.glBegin(GL2.GL_POINTS);
        for(int i=0; i<range; i++) {
            x= x + 1;
            y= Math.sqrt(x*20);
            gl.glVertex2d(-x, y);
        }

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

        gl.glVertex2d(-x, y);
        gl.glVertex2d(-y, x);

        gl.glVertex2d(-x, -y);
       // gl.glVertex2d(-y, -x);


        gl.glVertex2d(x, -y);
       // gl.glVertex2d(y, -x);
        gl.glEnd();

    }

    void bracu_b(GL2 gl,int r, int n){
        int x = r, y = 0, d = -4 * r + 5;
        draw8Way_for_b(gl, x, y,n);
        while (y <= x) {
            if (d < 0) {
                d = d + ((2 * y + 3) * 4);
                y++;
            } else {
                d += ((-2 * x + 2 * y + 5) * 4);
                x--;
                y++;
            }
            draw8Way_for_b(gl, x, y,n);
        }
    }
    void draw8Way_for_b(GL2 gl, int x, int y, int n) {
        gl.glPointSize(5);
        gl.glBegin(GL2.GL_POINTS);
        if(n == 1) {
            gl.glVertex2d(x, y);
            gl.glVertex2d(y, x);
            gl.glVertex2d(x, -y);
            gl.glVertex2d(y, -x);
        }else if(n == 0){
            gl.glVertex2d(y,x);
            gl.glVertex2d(y,-x);

            gl.glVertex2d(-x, y);
            gl.glVertex2d(-y, x);

             gl.glVertex2d(-x, -y);
             gl.glVertex2d(-y, -x);
        } else{

            gl.glVertex2d(-x, -y);
            gl.glVertex2d(-y, -x);
            gl.glVertex2d(x, -y);
            gl.glVertex2d(y, -x);
        }


        gl.glEnd();

    }
    void bracu_R(GL2 gl,int r){
        gl.glClearColor( 1, 1, 1, 1);
        int x = r, y = 0, d = -4 * r + 5;
        draw8Way_forR(gl, x, y);
        while (y <= x) {
            if (d < 0) {
                d = d + ((2 * y + 3) * 4);
                y++;
            } else {
                d += ((-2 * x + 2 * y + 5) * 4);
                x--;
                y++;
            }
            draw8Way_forR(gl, x, y);
        }
    }
    void line_R(GL2 gl){
        double x=0,y=0;
        gl.glBegin(GL2.GL_POINTS);
        for(int i=0; i<80; i++) {
            x= x + .2;

            y= x ;
            gl.glVertex2d(x, -y);
        }
        gl.glEnd();
    }
    void line_A(GL2 gl, int n){
        double x=0,y=0;
        gl.glBegin(GL2.GL_POINTS);
        for(int i=0; i<33; i++) {
            x= x + .5;

            y= x * 2.5 ;
            if(n == 1){
                gl.glVertex2d(-x, y);
            }else{
                gl.glVertex2d(x, y);
            }
        }
        gl.glEnd();
    }
    void draw8Way_forR(GL2 gl, int x, int y) {
        gl.glPointSize(5);
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(x, y);
        gl.glVertex2d(y, x);
        gl.glEnd();
    }
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glClearColor( 1, 1, 1, 1);

        gl.glPushMatrix();
        gl.glColor3d(0, 0, 1);
        gl.glTranslated(0,0,0);
        circle(gl,100);
        gl.glPopMatrix();

        range = range - 10;
        gl.glPushMatrix();
        gl.glTranslated(0, -70, 0);
        curve_zone1(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(0, -70, 0);
        curve_zone2(gl);
        gl.glPopMatrix();

        //curve 2
        gl.glColor3d(0, 0, 0);
        gl.glPushMatrix();
        gl.glTranslated(0, -90, 0);
        curve_zone1(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(0, -90, 0);
        curve_zone2(gl);
        gl.glPopMatrix();

        //curve 3
        gl.glColor3d(.5, .5, .5);
        gl.glPushMatrix();
        gl.glTranslated(0, -110, 0);
        curve_zone1(gl);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(0, -110, 0);
        curve_zone2(gl);
        gl.glPopMatrix();

        //B
        gl.glColor3d(0, 0, 0);
        gl.glPushMatrix();
        gl.glTranslated(-60, 44, 0);
        bracu_b(gl, 10,1);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslated(-60, 23, 0);
        bracu_b(gl, 10,1);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslated(-60, 15, 0);
        gl.glLineWidth(5);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,40);
        gl.glEnd();
        gl.glPopMatrix();
        //R
        gl.glPushMatrix();
        gl.glTranslated(-43, 9, 0);
        gl.glLineWidth(5);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,45);
        gl.glEnd();
        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glTranslated(-40, 42, 0);
        bracu_b(gl, 10,1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(-40, 30, 0);
        line_R(gl);
        gl.glPopMatrix();

        //A
        gl.glPushMatrix();
        gl.glTranslated(-25, 10, 0);
        line_A(gl,0);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(7, 10, 0);
        line_A(gl,1);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(-20, 30, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2f(20,0);
        gl.glEnd();
        gl.glPopMatrix();

        //C
        gl.glPushMatrix();
        gl.glTranslated(25, 32, 0);
        bracu_b(gl, 18,0);
        gl.glPopMatrix();
        //U
        gl.glPushMatrix();
        gl.glTranslated(58, 24, 0);
        bracu_b(gl, 15,5);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(43, 26, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,25);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslated(73, 24, 0);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(0,0);
        gl.glVertex2d(0,26);
        gl.glEnd();
        gl.glPopMatrix();


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
public class bracu
{
    public static void main(String args[])
    {
        //getting the capabilities object of GL2 profile
        final GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        // The canvas
        final GLCanvas glcanvas=new GLCanvas(capabilities);
        ThirdGLEventListener b=new ThirdGLEventListener();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame=new JFrame("BRACU");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(640,480);
        frame.setVisible(true);
    }
}

