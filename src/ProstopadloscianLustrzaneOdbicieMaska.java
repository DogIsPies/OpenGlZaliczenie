
import com.jogamp.opengl.GL2;

public class ProstopadloscianLustrzaneOdbicieMaska {


	public static void Draw(GL2 gl,float a,float b,float h,int n,int m,int p,int gora,int frontTyl,int lewaPrawa ){

		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, gora);
					gl.glNormal3f(0,-1,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);

//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					//góra
					gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<p-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, frontTyl);
					gl.glNormal3f(0,0,1);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
//					//front i tył
					gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*(i+1)/(p-1),b/2);
					gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*(i+1)/(p-1),b/2);

					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,1,0);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<p-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, lewaPrawa);
					gl.glNormal3f(1,0,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					//lewa prawa
					gl.glTexCoord2f(0.0f,0.0f);gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*i/(m-1));
					gl.glTexCoord2f(0.0f,1.0f);gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*i/(m-1));
					gl.glTexCoord2f(1.0f,1.0f);gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glTexCoord2f(1.0f,0.0f);gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}

	}
	public static void Draw(GL2 gl,float a,float b,float h,int n,int m,int p,int gora,int frontTyl,int lewaPrawa,  float textureXBok1, float textureYBok1,float textureXBok2, float textureYBok2, float textureXBok3, float textureYBok3,float textureXBok4, float textureYBok4 ){

		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, gora);
					gl.glNormal3f(0,-1,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);

//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					//góra
					gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*i/(m-1));
					gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2,-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<p-1;i++)
				for(int j=0;j<n-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, frontTyl);
					gl.glNormal3f(0,0,1);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					//front i tył
					gl.glTexCoord2f(0.0f,0.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glTexCoord2f(1.0f,0.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*i/(p-1),b/2);
					gl.glTexCoord2f(1.0f,1.0f); gl.glVertex3f(-a/2+a*(j+1)/(n-1),-h/2+h*(i+1)/(p-1),b/2);
					gl.glTexCoord2f(0.0f,1.0f); gl.glVertex3f(-a/2+a*j/(n-1),-h/2+h*(i+1)/(p-1),b/2);
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,1,0);
		}
		for(int k=0;k<2;k++){
			for(int i=0;i<m-1;i++)
				for(int j=0;j<p-1;j++){
					gl.glBindTexture(GL2.GL_TEXTURE_2D, lewaPrawa);
					gl.glNormal3f(1,0,0);
					gl.glPushAttrib(GL2.GL_CURRENT_BIT);
//					if((i+j)%2==0) gl.glColor3f(0.0f,0.0f,0.0f);
					gl.glBegin(GL2.GL_QUADS);
					//lewa prawa
					gl.glTexCoord2f(textureXBok1,textureYBok1);gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*i/(m-1));
					gl.glTexCoord2f(textureXBok2,textureYBok2);gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*i/(m-1));
					gl.glTexCoord2f(textureXBok3,textureYBok3);gl.glVertex3f(a/2,-h/2+h*(j+1)/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glTexCoord2f(textureXBok4,textureYBok4);gl.glVertex3f(a/2,-h/2+h*j/(p-1),-b/2+b*(i+1)/(m-1));
					gl.glEnd();
					gl.glPopAttrib();
				}
			gl.glRotatef(180,0,0,1);
		}

	}
}
