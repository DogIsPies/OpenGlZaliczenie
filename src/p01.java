
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseMotionAdapter;
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

public class p01 extends JFrame implements GLEventListener, KeyListener {

    private GL2 gl;
    private GLU glu;
    private GLUT glut;
    private FPSAnimator animator;
    private float kat = 0.0f;

    private float obrotswiatel = 0.0f;
    private float obrot = 25.0f;
    private float skret = 0.0f;

    private boolean turnOnLights = false;

    private int tyl, oknoBok, oknotyl, przod, gora, las, guma, felga, red, blue, przodmaskilewa, przodmaskiprawa, trawa;

    public p01(String string) {
        super(string);
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities capabilities = new GLCapabilities(profile);
        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(this);
        add(canvas);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension d = kit.getScreenSize();
        setBounds(d.width / 4, d.height / 4, d.width / 2, d.height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setVisible(true);
        canvas.addKeyListener(this);
        animator = new FPSAnimator(canvas, 60);

        animator.start();
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        //tło
        gl.glDisable(GL2.GL_DEPTH_TEST);
        gl.glDisable(GL2.GL_LIGHTING);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPushMatrix();
        gl.glLoadIdentity();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glBindTexture(GL2.GL_TEXTURE_2D, las);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(1.0f, 1.0f, -1.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-1.0f, 1.0f, -1.0f);
        gl.glEnd();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glPopMatrix();
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glEnable(GL2.GL_LIGHTING);

        int lKrawedzi = 2;
        float r = 0.25f;
        float hWalca = 0.1f;
        float xCiala = 1.0f;
        float zCiala = 2.0f;
        float hCiala = 1.0f;



        gl.glLoadIdentity();
        gl.glPushMatrix();

        gl.glTranslatef(0.0f, -1.0f-(hCiala)-(hWalca), 0.0f);
        Prostopadloscian.Draw(gl, 20.0f, 20.0f, 0.1f, lKrawedzi*4, lKrawedzi*4, lKrawedzi*4, trawa,trawa,trawa);

        gl.glPopMatrix();
        //gl.glRotatef(kat, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(obrot, 0.0f, 1.0f, 0.0f);
        //gl.glRotatef(kat, 0.0f, 0.0f, 1.0f);
//        gl.glColor3f(1.0f, 1.0f, 0.0f);








        //tyl auta prawa strona
        gl.glPushMatrix();

        gl.glTranslatef(-xCiala/4.0f, -1.0f, -zCiala/4.0f);
        Prostopadloscian.Draw(gl, xCiala/2.0f, zCiala/2.0f, hCiala, lKrawedzi, lKrawedzi, lKrawedzi, gora,tyl,oknotyl);
        gl.glPopMatrix();

        //tyl auta lewa strona
        gl.glPushMatrix();

        gl.glTranslatef(xCiala/4.0f, -1.0f, -zCiala/4.0f);
        ProstopadloscianLustrzaneOdbicie.Draw(gl, xCiala/2.0f, zCiala/2.0f, hCiala, lKrawedzi, lKrawedzi, lKrawedzi, gora,tyl,oknotyl);
        gl.glPopMatrix();




        //przod auta prawa strona
        gl.glPushMatrix();

        gl.glTranslatef(-xCiala/4.0f, -1.0f, zCiala/4.0f);
        Prostopadloscian.Draw(gl, xCiala/2.0f, zCiala/2.0f, hCiala, lKrawedzi, lKrawedzi, lKrawedzi, gora,przod,oknoBok);
        gl.glPopMatrix();

        //przod auta lewa strona
        gl.glPushMatrix();

        gl.glTranslatef(xCiala/4.0f, -1.0f, zCiala/4.0f);
        ProstopadloscianLustrzaneOdbicie.Draw(gl, xCiala/2.0f, zCiala/2.0f, hCiala, lKrawedzi, lKrawedzi, lKrawedzi, gora,przod,oknoBok);
        gl.glPopMatrix();

        //maska lewa
        gl.glPushMatrix();

        gl.glTranslatef(xCiala/4.0f, -1.25f, 1.125f);
        ProstopadloscianMaska.Draw(gl, xCiala/2.0f, zCiala/8.0f, hCiala/2.0f, lKrawedzi, lKrawedzi, lKrawedzi, gora,przodmaskiprawa,oknotyl,
                0.0f,0.0f,0.0f,0.5f,0.125f,0.5f,0.125f,0.0f);
        gl.glPopMatrix();

        //maskaprawa
        gl.glPushMatrix();

        gl.glTranslatef(-xCiala/4.0f, -1.25f, 1.125f);
        ProstopadloscianLustrzaneOdbicieMaska.Draw(gl, xCiala/2.0f, zCiala/8.0f, hCiala/2.0f, lKrawedzi, lKrawedzi, lKrawedzi, gora,przodmaskilewa,oknotyl,
                0.0f,0.5f,0.0f,0.0f,0.125f,0.0f,0.125f,0.5f);
        gl.glPopMatrix();


        gl.glPushMatrix();
        //prawa przednia opona
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(90, 0.0f, 0.0f, 1.0f);

        gl.glPushMatrix();

        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f), ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(skret, 0.0f, 0.0f, 1.0f);
        gl.glRotatef(-kat, 0.0f, 1.0f, 0.0f);

        Walec.Draw(gl, r, hWalca, 10, 2, guma, 0.25f);
        gl.glPopMatrix();

        //prawa przednia felga
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f), ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(skret, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.0f, hWalca / 2.0f, 0.0f);
        gl.glRotatef(-kat, 0.0f, 1.0f, 0.0f);

        Kolo.Draw(gl, r, 10, 5, felga);
        gl.glPopMatrix();
        //prawa tylna opona
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f) * -1, ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(-kat, 0.0f, 1.0f, 0.0f);
        Walec.Draw(gl, r, hWalca, 10, 2, guma,0.25f);
        gl.glPopMatrix();

        //prawa tylna felga
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f) * -1, ((xCiala / 2.0f) + hWalca), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(-kat, 0.0f, 1.0f, 0.0f);
        Kolo.Draw(gl, r, 10, 5, felga);
        gl.glPopMatrix();
        gl.glPopMatrix();

        gl.glPushMatrix();
        //tylna lewa opona
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(270, 0.0f, 0.0f, 1.0f);


        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f), ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
        Walec.Draw(gl, r, hWalca, 10, 2, guma,0.25f);
        gl.glPopMatrix();

        //tylna lewa felga
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f), ((xCiala / 2.0f) + hWalca), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
        Kolo.Draw(gl, r, 10, 5, felga);
        gl.glPopMatrix();
        //przednia lewa opona
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f) * -1, ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(skret, 0.0f, 0.0f, 1.0f);
        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);

        Walec.Draw(gl, r, hWalca, 10, 2, guma,0.25f);
        gl.glPopMatrix();

        //przednia lewa felga
        gl.glPushMatrix();
        gl.glTranslatef(((xCiala / 2.0f) + r / 2.0f) * -1, ((xCiala / 2.0f) + (hWalca / 2.0f)), 1.0f + (hCiala / 2.0f));
        gl.glRotatef(skret, 0.0f, 0.0f, 1.0f);
        gl.glTranslatef(0.0f, hWalca / 2.0f, 0.0f);
        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);

        Kolo.Draw(gl, r, 10, 5, felga);
        gl.glPopMatrix();
        gl.glPopMatrix();


        //kogut
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -1.0f + (hCiala / 2.0f) + (hCiala / 10.0f), zCiala / 3.0f);
        Prostopadloscian.Draw(gl, xCiala / 4.0f, zCiala / 10.0f, hCiala / 5.0f, 2, 2, 2,gora,gora,gora);
        gl.glPopMatrix();
        //lewe światło koguta
        gl.glPushMatrix();
        gl.glTranslatef(zCiala / 10.0f, -1.0f + (hCiala / 2.0f) + (hCiala / 10.0f), zCiala / 3.0f);
        gl.glRotatef(-obrotswiatel * 4.0f, 0.0f, 1.0f, 0.0f);
        Walec.Draw(gl, zCiala / 20.0f, hCiala / 5.0f, 6, 2, red,1.0f);

        gl.glTranslatef(0.0f, (hCiala / 5.0f)/2.0f, 0.0f);
        Kolo.Draw(gl,zCiala/20.0f, 8,2,red);
        gl.glPopMatrix();


        //prawe światło koguta
        gl.glPushMatrix();
        gl.glTranslatef(-zCiala / 10.f, -1.0f + (hCiala / 2.0f) + (hCiala / 10.0f), zCiala / 3.0f);
        gl.glRotatef(obrotswiatel * 4.0f, 0.0f, 1.0f, 0.0f);
        Walec.Draw(gl, zCiala / 20.0f, hCiala / 5.0f, 6, 2, blue,1.0f);

        gl.glTranslatef(0.0f, (hCiala / 5.0f)/2.0f, 0.0f);
        Kolo.Draw(gl,zCiala/20.0f, 8,2,blue);

        gl.glPopMatrix();

        if(turnOnLights) {
            obrotswiatel += 1.0f;
            if (obrotswiatel >= 360.0f)
                obrotswiatel -= 360.0f;
        }
        else obrotswiatel = 0.0f;

        gl.glFlush();


    }


    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        gl = drawable.getGL().getGL2();
        glu = GLU.createGLU(gl);
        glut = new GLUT();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glEnable(GL2.GL_DEPTH_TEST);

        gl.glEnable(GL2.GL_CULL_FACE);
        float matSpec[] = {1.0f, 1.0f, 1.0f, 1.0f};
        gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, matSpec, 0);
        gl.glMateriali(GL2.GL_FRONT, GL2.GL_SHININESS, 128);

        gl.glEnable(GL2.GL_COLOR_MATERIAL);
        gl.glColorMaterial(GL2.GL_FRONT, GL2.GL_AMBIENT_AND_DIFFUSE);

        float ambientLight[] = {0.1f, 0.1f, 0.1f, 1.0f};
        gl.glLightModelfv(GL2.GL_LIGHT_MODEL_AMBIENT, ambientLight, 0);

        gl.glEnable(GL2.GL_LIGHTING);

        float ambient[] = {0.1f, 0.1f, 0.1f, 1.0f};
        float diffuse[] = {0.5f, 0.5f, 0.5f, 1.0f};
        float specular[] = {1.0f, 1.0f, 1.0f, 1.0f};
        float position[] = {-2.0f, 2.0f, 3.0f, 1.0f};

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, ambient, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, specular, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, position, 0);

        gl.glEnable(GL2.GL_LIGHT0);
        //gl.glEnable(GL2.GL_NORMALIZE);

        gl.glEnable(GL2.GL_TEXTURE_2D);
        try {
            File f = new File("gora.jpg");
            Texture t = TextureIO.newTexture(f, true);
            gora = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("tyl.jpg");
            Texture t = TextureIO.newTexture(f, true);
            tyl = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("przod.jpg");
            Texture t = TextureIO.newTexture(f, true);
            przod = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("Rokono_bok.jpg");
            Texture t = TextureIO.newTexture(f, true);
            oknoBok = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("LOGO_bok.jpg");
            Texture t = TextureIO.newTexture(f, true);
             oknotyl= t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("las.jpg");
            Texture t = TextureIO.newTexture(f, true);
            las = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("rubber.jpg");
            Texture t = TextureIO.newTexture(f, true);
            guma = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("felgi.jpg");
            Texture t = TextureIO.newTexture(f, true);
            felga = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("RED.jpg");
            Texture t = TextureIO.newTexture(f, true);
            red = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("BLUE.jpg");
            Texture t = TextureIO.newTexture(f, true);
            blue = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("przodmaskilewa.jpg");
            Texture t = TextureIO.newTexture(f, true);
            przodmaskilewa = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("przodmaskiprawa.jpg");
            Texture t = TextureIO.newTexture(f, true);
            przodmaskiprawa = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File f = new File("trawa.jpg");
            Texture t = TextureIO.newTexture(f, true);
            trawa = t.getTextureObject(gl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = gl.glGetString(GL2.GL_RENDERER);
        setTitle(s);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
                        int height) {
        gl.glViewport(0, 0, width, height);
        if (height == 0)
            height = 1;
        float aspect = (float) width / height;
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(55.0, aspect, 1.0f, 10.0f);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()) {

            case ('a'): {

                if(skret>-25.0f){
                    skret -= 1.0f;
                }

//                System.out.println(e.getKeyChar() + " " + skret);
                break;
            }
            case ('d'): {
                if(skret<25.0f){
                    skret += 1.0f;
                }

//                System.out.println(e.getKeyChar() + " " + skret);
                break;
            }

            case ('w'): {
                kat += 2.0f;
//                System.out.println(e.getKeyChar() + " " + kat);
                break;
            }
            case ('s'): {
                kat -= 2.0f;
//                System.out.println(e.getKeyChar() + " " + kat);
                break;
            }
            case ('y'): {
                obrot -= 1.0f;
//                System.out.println(e.getKeyChar() + " " + kat);
                break;
            }
            case ('u'): {
                obrot += 1.0f;
//                System.out.println(e.getKeyChar() + " " + kat);
                break;
            }


            default:
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyChar() == 't'&& !turnOnLights){
            turnOnLights = true;

        }
        else if(e.getKeyChar()=='t' && turnOnLights){
            turnOnLights = false;
        }

    }

}