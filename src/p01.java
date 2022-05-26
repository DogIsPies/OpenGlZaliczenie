
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

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
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class p01 extends JFrame implements GLEventListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private FPSAnimator animator;
    private float kat=0.0f;

    private int texture;

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
        gl.glRotatef(kat*(1.0f/2.0f), 0.0f, 1.0f, 0.0f);
        //gl.glRotatef(kat, 0.0f, 0.0f, 1.0f);
//        gl.glColor3f(1.0f, 1.0f, 0.0f);


        int s = 5;
        int p = 4;
        float r = 0.25f;
        float hWalca = 0.1f;
        float xCiala = 1.0f;
        float zCiała = 2.0f;
        float hCiała = 1.0f;
//        float sh = h/2;
//        float sr = r/20;
//        int n =(int)Math.round(4*Math.PI*r/h),  m=3, k=(int)Math.round(2*r/h);



                    //ciałko
        gl.glPushMatrix();

        gl.glTranslatef(0.0f,-1.0f,0.0f);
        Prostopadloscian.Draw(gl,xCiala,zCiała,hCiała,2,2,2,texture);
        gl.glPopMatrix();

                    //maska
        gl.glPushMatrix();

        gl.glTranslatef(0.0f,-1.25f,1.125f);
        Prostopadloscian.Draw(gl,1.0f,0.25f,0.5f,2,2,2,texture);
        gl.glPopMatrix();


        gl.glPushMatrix();
                        //prawa przednia opona
            gl.glRotatef(90,1.0f,0.0f,0.0f);
            gl.glRotatef(90,0.0f,0.0f,1.0f);

            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f),((xCiala/2.0f)+(hWalca/2.0f)),1.0f+(hCiała/2.0f));
                gl.glRotatef(-kat*2.0f, 0.0f, 1.0f, 0.0f);
                Walec.Draw(gl,r,hWalca,10,2,texture);
            gl.glPopMatrix();

                    //prawa przednia felga
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f),((xCiala/2.0f)+hWalca),1.0f+(hCiała/2.0f));
                gl.glRotatef(-kat*2.0f, 0.0f, 1.0f, 0.0f);
                Kolo.Draw(gl,r,10,5,texture);
            gl.glPopMatrix();
                    //prawa tylna opona
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f)*-1,((xCiala/2.0f)+(hWalca/2.0f)),1.0f+(hCiała/2.0f));
                gl.glRotatef(-kat*2.0f, 0.0f, 1.0f, 0.0f);
                Walec.Draw(gl,r,hWalca,10,2,texture);
            gl.glPopMatrix();

                    //prawa tylna felga
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f)*-1,((xCiala/2.0f)+hWalca),1.0f+(hCiała/2.0f));
                gl.glRotatef(-kat*2.0f, 0.0f, 1.0f, 0.0f);
                Kolo.Draw(gl,r,10,5,texture);
            gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glPushMatrix();
                    //prawa lewa opona
            gl.glRotatef(90,1.0f,0.0f,0.0f);
            gl.glRotatef(270,0.0f,0.0f,1.0f);


            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f),((xCiala/2.0f)+(hWalca/2.0f)),1.0f+(hCiała/2.0f));
                gl.glRotatef(kat*2.0f, 0.0f, 1.0f, 0.0f);
                Walec.Draw(gl,r,hWalca,10,2,texture);
            gl.glPopMatrix();

                    //prawa lewa felga
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f),((xCiala/2.0f)+hWalca),1.0f+(hCiała/2.0f));
                gl.glRotatef(kat*2.0f, 0.0f, 1.0f, 0.0f);
                Kolo.Draw(gl,r,10,5,texture);
            gl.glPopMatrix();
                    //prawa lewa opona
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f)*-1,((xCiala/2.0f)+(hWalca/2.0f)),1.0f+(hCiała/2.0f));
                gl.glRotatef(kat*2.0f, 0.0f, 1.0f, 0.0f);
                Walec.Draw(gl,r,hWalca,10,2,texture);
            gl.glPopMatrix();

                    //prawa lewa felga
            gl.glPushMatrix();
                gl.glTranslatef(((xCiala/2.0f)+r/2.0f)*-1,((xCiala/2.0f)+hWalca),1.0f+(hCiała/2.0f));
                gl.glRotatef(kat*2.0f, 0.0f, 1.0f, 0.0f);
                Kolo.Draw(gl,r,10,5,texture);
            gl.glPopMatrix();
        gl.glPopMatrix();



        //kogut
        gl.glPushMatrix();
            gl.glTranslatef(0.0f,-1.0f+(hCiała/2.0f)+(hCiała/10.0f),zCiała/3.0f);
            Prostopadloscian.Draw(gl,xCiala/4.0f,zCiała/10.0f,hCiała/5.0f,2,2,2,texture);
        gl.glPopMatrix();
        //lewe światło koguta
        gl.glPushMatrix();
            gl.glTranslatef(zCiała/10.0f,-1.0f+(hCiała/2.0f)+(hCiała/10.0f),zCiała/3.0f);
            gl.glRotatef(-kat*4.0f, 0.0f, 1.0f, 0.0f);
            Walec.Draw(gl,zCiała/20.0f,hCiała/5.0f,8,2,texture);
        gl.glPopMatrix();
        //prawe światło koguta
        gl.glPushMatrix();
            gl.glTranslatef(-zCiała/10.f,-1.0f+(hCiała/2.0f)+(hCiała/10.0f),zCiała/3.0f);
            gl.glRotatef(kat*4.0f, 0.0f, 1.0f, 0.0f);
            Walec.Draw(gl,zCiała/20.0f,hCiała/5.0f,8,2,texture);
        gl.glPopMatrix();






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

        gl.glEnable(GL2.GL_TEXTURE_2D);
        try{
            File f=new File("usmiech.jpg");
            Texture t= TextureIO.newTexture(f, true);
            texture=t.getTextureObject(gl);
        }catch(IOException e){
            e.printStackTrace();
        }

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
