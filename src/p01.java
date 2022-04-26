
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.gl2.GLUT;

public class p01 extends JFrame implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private FPSAnimator animator;
    private float kat=0.0f;

    public p01(String string) {
        super(string);
        GLProfile profile=GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities=new GLCapabilities(profile);
        GLCanvas canvas=new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        add(canvas);
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension d=kit.getScreenSize();
        setBounds(d.width/4, d.height/4, d.width/2, d.height/2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        animator=new FPSAnimator(canvas,60);
        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        //gl.glRotatef(kat, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
        //gl.glRotatef(kat, 0.0f, 0.0f, 1.0f);
        gl.glColor3f(1.0f, 1.0f, 0.0f);

        int s = 5;
        int p = 4;
        float r = 1.0f;
        float h = 0.25f;
        float sh = h/2;
        float sr = r/20;
        int n =(int)Math.round(4*Math.PI*r/h),  m=3, k=(int)Math.round(2*r/h);


        gl.glPushMatrix();
        gl.glTranslatef(0.0f,-1.25f,0.0f);
        Prostopadloscian.Draw(gl,1.0f,2.0f,1.0f,3,5,3);

        gl.glTranslatef(0.0f,-0.25f,1.125f);
        Prostopadloscian.Draw(gl,1.0f,0.25f,0.5f,3,2,3);

        gl.glRotatef(90,1.0f,0.0f,0.0f);
        gl.glRotatef(90,0.0f,0.0f,1.0f);
        gl.glTranslatef(-0.425f,0.55f,0.2f);
        Walec.Draw(gl,0.25,0.1,10,5);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f,0.05f,0.0f);
        Kolo.Draw(gl,0.25,10,5);
        gl.glPopMatrix();

        gl.glRotatef(180,1.0f,0.0f,0.0f);
        gl.glTranslatef(0.0f,1.1f,0.0f);
        Walec.Draw(gl,0.25,0.1,10,5);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f,0.05f,0.0f);
        Kolo.Draw(gl,0.25,10,5);
        gl.glPopMatrix();

        gl.glTranslatef(-1.3f,0.0f,0.0f);
        Walec.Draw(gl,0.25,0.1,10,5);


        gl.glPushMatrix();
        gl.glTranslatef(0.0f,0.05f,0.0f);
        Kolo.Draw(gl,0.25,10,5);
        gl.glPopMatrix();

        gl.glRotatef(180,1.0f,0.0f,0.0f);
        gl.glTranslatef(0.0f,1.1f,0.0f);
        Walec.Draw(gl,0.25,0.1,10,5);


        gl.glPushMatrix();
        gl.glTranslatef(0.0f,0.05f,0.0f);
        Kolo.Draw(gl,0.25,10,5);
        gl.glPopMatrix();

        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glTranslatef(0.0f,-0.625f,0.7f);
        Prostopadloscian.Draw(gl,0.5f,0.25f,0.25f,3,3,3);
        gl.glPopMatrix();





//        Walec.Draw(gl,r,h,n,m);
//        gl.glPushMatrix();
//        gl.glTranslatef(0.0f,h/2,0.0f);
//        gl.glRotatef(360/n,0.0f,1.0f,0.0f);
//        Kolo.Draw(gl,r,n,k);
//        gl.glPopMatrix();
//
//        gl.glPushMatrix();
//        gl.glRotatef(180,1.0f,0.0f,0.0f);
//        gl.glTranslatef(0.0f,h/2,0.0f);
//        gl.glRotatef(360/n,0.0f,1.0f,0.0f);
//        Kolo.Draw(gl,r,n,k);
//        gl.glPopMatrix();
//
//        gl.glPushMatrix();
//
//        for(int i =0; i<s;i++){
//            gl.glPushMatrix();
//            gl.glRotatef(360*i/s,0.0f,1.0f,0.0f);
//            gl.glTranslatef(0.0f,h/2+sh/2,r-(3*sr));
//            gl.glColor3f(1.0f,0.0f,0.0f);
//            Walec.Draw(gl,sr,sh,16,16);
//            gl.glPopMatrix();
//            gl.glPushMatrix();
//            gl.glRotatef(360*i/s,0.0f,1.0f,0.0f);
//            gl.glTranslatef(0.0f,sh/2+(h/2+sh/2),r-(3*sr));
//            gl.glColor3f(1.0f,1.0f,0.0f);
//            Kula.Draw(gl,r/17,16,16);
//            gl.glPopMatrix();
//        }
//        gl.glPopMatrix();
//        for(int i = 0;i<=8;i+=2){
//            gl.glTranslatef(0.0f,h,0.0f);
//            Prostopadloscian.Draw(gl,a-i*h,a-i*h,h,2*n-(i+1),2*n-(i+1),(int)(2*n*h)+1);
//        }



        gl.glFlush();
        kat+=1.0f;
        if(kat>=360.0f)
            kat-=360.0f;
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl=drawable.getGL().getGL2();
        glu=GLU.createGLU(gl);
        glut=new GLUT();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);

        gl.glEnable(GL2.GL_CULL_FACE);
        float matSpec[]={1.0f,1.0f,1.0f,1.0f};
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, matSpec, 0);
        gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);

        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE);

        float ambientLight[]={0.1f,0.1f,0.1f,1.0f};
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, ambientLight, 0);

        gl.glEnable(GL2.GL_LIGHTING);

        float ambient[]={0.1f,0.1f,0.1f,1.0f};
        float diffuse[]={0.5f,0.5f,0.5f,1.0f};
        float specular[]={1.0f,1.0f,1.0f,1.0f};
        float position[]={-2.0f,2.0f,3.0f,1.0f};

        gl.glLightfv(GL2.GL_LIGHT0,GL2.GL_AMBIENT,ambient,0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse,0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular,0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position,0);

        gl.glEnable(GL2.GL_LIGHT0);
        //gl.glEnable(GL2.GL_NORMALIZE);
        String s=gl.glGetString(GL2.GL_RENDERER);
        setTitle(s);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
        gl.glViewport(0, 0, width, height);
        if(height==0)
            height=1;
        float aspect=(float)width/height;
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0, aspect, 1.0, 10.0);
        glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new p01("p03");
            }
        });
    }

}
