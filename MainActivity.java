package com.example.game;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.EGLConfig;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity  {
    
	 OpenGLRenderer my;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println("i am here");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        GLSurfaceView view = new GLSurfaceView(this);
      my=new OpenGLRenderer();
        view.setRenderer(my);
        
        setContentView(view);
     
       
       
    }
   

    
    public boolean onTouchEvent(MotionEvent event)
    {
    	
    	float initialx = 5,initialy=0,finalx=0,finaly;
    	
    	if(my.gameover==0)
    	{
    	my.gameover=1;	
    	}
    	if(my.start==1)
    	{
    		my.start++;my.key=1;
    	}
		
	    if(my.start==2)
	    {
		my.fraudcount=my.fraudcount-0.5f;
	    }
		if(my.start==0)
		{
			my.start=1;my.fraudcount=1f;
		}
		
		if(my.fraudcount==0||my.fraudcount==0.5f)
		{
			my.left=0.5f;
			my.right=0;
		}
		switch(event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
		{	
			Toast.makeText(getApplicationContext(),"score is"+my.score,Toast.LENGTH_LONG).show();	my.score++;
		initialx=event.getX();
		initialy=event.getY();
		break;
		}
		
		case MotionEvent.ACTION_UP:
		{	
		finalx=event.getX();
		finaly=event.getY();
		
		if(initialx<finalx)
		{
			
			my.right=0.5f;
			my.left=0;my.fraudcount=1;
		
		}
		if(initialx>finalx)
		{
			
			my.left=0.5f;
			my.right=0;
		}
		break;
		}
		
		
		
		}
		
		
		
		return true;
    }

}




class OpenGLRenderer  implements Renderer
{
float a=0.0f,b=0.0f,c=-10.0f,c1=-10.0f,c2=-10.0f,c3=-10.0f,c20=-10.0f,c21=-10.0f;int conss=0;
float[]c4=new float[145];
float z[]=new float[145];int co=0,co1=0;
int t=0;int i=0;int key=0;int count=0;float const1=1.5f;
public float left=0,right=0;
public Cube[] m1cube=new Cube[15];float fraudcount=1;int start=0,score=0;
   public Cube[] bcube=new Cube[5];
   public Cube[] trian=new Cube[15];
   public Cube[]tower=new Cube[15];
   public Cube[]road=new Cube[145];
   public Cube[]strip=new Cube[145];
   public Cube[]wallsr=new Cube[2];
   public Cube[]wallsl=new Cube[2];
   public Cube head;
   public Cube neck;
   public Cube body;
   public Cube hands;
   public Cube lower;
   public Cube leg1;public Cube leg2;
   public Cube hair;
   public Cube trowser1;
   public Cube trowser2;
   public Cube middletrowser;
   public Cube shoe1;public Cube shoe2;
   public Cube shoe21;public Cube shoe22;
   public Cube side1,side2;
   
    private float mCubeRotation,mCubeRotation1;
    public int count1=0;public int a1=0; public int gameover=0;
   
    public float hx=0.6f,nx=0.7625f,tx=0.975f,s1x=0.56f,s2x=0.945f;
    public float tr=0.0f;
    public int objectcount=0;
   MainActivity displaytext;
     public OpenGLRenderer()
    {
    	float y=-2,d= 0.031f,a=0.0f,l=0.0f,x=4f;
    	conss=1;
    	
		    
    	displaytext=new MainActivity();
    	side1=new Cube(-15.75f,-2.5f,5,12f,145,0.1f,110,231,124);
    	side2=new Cube(4f,-2.5f,5,12f,145,0.1f,110,231,124);	
    	
    	
    	head=new Cube(hx,0.335f,4.5f,0.5f,0.4f,0.4f,255,223,196);
    	hair=new Cube(hx,0.335f,4.5f,0.5f,0.4f,0.1f,107,107,99);
    	neck=new Cube(nx,-0.065f,4.83f,0.165f,0.4f,0.125f,255,223,196);
    	body=new Cube(hx,-0.1675f,4.5f,0.5f,0.4f,0.5f,62,127,216);
    	trowser1=new Cube(hx,-0.7075f,4.5f,0.125f,0.4f,0.25f,179,60,159);
    	trowser2=new Cube(tx,-0.7075f,4.5f,0.125f,0.4f,0.25f,179,60,159);
    	middletrowser =new Cube(hx,-0.7075f,4.5f,0.5f,0.4f,0.125f,179,60,159);
    	leg1=new Cube(hx,-0.7075f,4.5f,0.125f,0.4f,0.5f,255,223,196);
    	leg2=new Cube(tx,-0.7075f,4.5f,0.125f,0.4f,0.5f,255,223,196);
    	shoe1=new Cube(s1x,-1.2075f,4.5f,0.175f,0.4f,0.045f,107,107,99);
    	shoe2=new Cube(s2x,-1.2075f,4.5f,0.175f,0.4f,0.045f,107,107,99);
    	shoe21=new Cube(s1x,-1f,4.5f,0.175f,0.045f,0.3f,107,107,99);
    	shoe22=new Cube(s2x,-1f,4.5f,0.175f,0.045f,0.3f,107,107,99);
    	
    	
    	wallsr[0]=new Cube(-2.0f,-1f,0,1.6f,0.4f,0.5f,255,111,111);
    	wallsr[1]=new Cube(-2.0f,-0.5f,0,1.6f,0.4f,0.5f,255,255,255);
    	wallsl[0]=new Cube(0.6f,-1f,-20f,1.6f,0.4f,0.5f,255,111,111);
    	wallsl[1]=new Cube(0.6f,-0.5f,-20f,1.6f,0.4f,0.5f,255,255,255);
    	
    	for(i=0;i<20;i++)
    	{
    		c4[i]=-10.0f;
    	}
    	
    	for(i=0;i<145;i++)
    	{
    		z[i]=x;x--;
    		road[i]=new Cube(-3.75f,-2.5f,z[i],7.75f,1,0.1f,66,68,69);
    		if(co<=5&&co1<=0)
    		{
    			co++;
    			strip[i]=new Cube(-0.45f,-2.5f,z[i],1,1,0.1f,255,255,255);
    		}
    		else
    		{
    			strip[i]=new Cube(-0.45f,-2.5f,z[i],1,1,0.1f,66,68,69);
    			co1++;
    			if(co1==5){co=0;co1=0;}
    		}
    		
    	}
    	y=-1.5f;
    	for(i=0;i<15;i++)
    	{
    		m1cube[i]=new Cube(4,y,0,1,1,1,252-10*i,199-10*i,149-10*i);
    		y=y+0.33f;
    	}
    	y=-2;
    	for(i=0;i<5;i++)
    	{
    		bcube[i]=new Cube(-6,y,-6f,2f,1f,1,247-20*i,247-30*i,171-40*i);
    		y=y+1;
    	}
    	y=-2;
    	for(i=0;i<15;i++)
    	{
    		trian[i]=new Cube(-6+a,y,1-a,(float) (2-2*l),1-2*l,0.33f,252-10*i,179-10*i,169-10*i);
    		y=y+0.33f;
    		a=a+d;l=l+d;
    	}
    	y=-2;
    	for(i=0;i<15;i++)
    	{
    		if(i%2==0){tower[i]=new Cube(4,y,-6f,2,1.5f,0.33f,56-5*i,224-10*i,47-5*i);  }
    		else if(i%2==1){ tower[i]=new Cube(4+0.25f,y,-6-0.25f,1.5f,1.0f,0.33f,56-5*i,224-10*i,47-5*i);      }
    		y=y+0.33f;
    	}
    	
    	
    		
    }
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
    
        gl.glClearColor(1.0f, 1.0f, 0.8f, 0.5f); 
            
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);

        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,
                  GL10.GL_NICEST);
       
            
    }

    @Override
    public void onDrawFrame(GL10 gl) {
    	
    	gl.glClearColor(0.639f, 0.9647f, 1f, 0.5f);
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT); 
        
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10);
        side1.draw(gl);
        gl.glLoadIdentity();
        gl.glTranslatef(0,0,-10);
        side2.draw(gl);
     
        
        gl.glLoadIdentity();
        gl.glTranslatef(a,b,c);
       for(i=0;i<5;i++)
      {
    	bcube[i].draw(gl);
      }
     
     gl.glLoadIdentity();
     gl.glTranslatef(a,b,c3);
      for(i=0;i<15;i++)
      {
    	tower[i].draw(gl);
      }
      
     gl.glLoadIdentity();
     gl.glTranslatef(a,b,c1);
      for(i=0;i<15;i++)
      {
    	m1cube[i].draw(gl);
      }
      
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c2);
      for(i=0;i<15;i++)
      {
    	trian[i].draw(gl);
      }
      
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c2);
      for(i=0;i<145;i++)
    	  
      {
    	  gl.glLoadIdentity();
          gl.glTranslatef(a,b,c4[i]);
    	  road[i].draw(gl);
    	  strip[i].draw(gl);
      }
      
    
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c20);
      wallsr[0].draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c20);
      wallsr[1].draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c21);
      wallsl[0].draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(a,b,c21);
      wallsl[1].draw(gl);
      
      if(objectcount>5&&objectcount<=10)
      {	  
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      shoe21.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      shoe2.draw(gl);
      }
      if(objectcount<=5)  //to stop character running after gameover
      {
    	  gl.glLoadIdentity();
          gl.glTranslatef(tr,0,-10);
          shoe1.draw(gl);
          gl.glLoadIdentity();
          gl.glTranslatef(tr,0,-10);
          shoe22.draw(gl);
          
      }
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      leg1.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      leg2.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      trowser1.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      trowser2.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      middletrowser.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      head.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      hair.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      neck.draw(gl);
      gl.glLoadIdentity();
      gl.glTranslatef(tr,0,-10);
      body.draw(gl);
     
     
     
      count++;
      
      if(key==1)
      {
      objectcount=(objectcount+1)%10;
      }
        if(count>200&&count<400){const1=2;}else if(count>400){const1=3;}
        if(c>6){c=-14;}else if(c<6&&key==1){c=(float) (c+const1*0.07);}
        if(c1>0){c1=-20;}else if(c1<0&&key==1){c1=(float) (c1+const1*0.07);}
        if(c2>-1){c2=-21;}	else if(c2<-1&&key==1){c2=(float) (c2+const1*0.07);}
        if(c3>6){c3=-14;}	else if(c3<6&&key==1){c3=(float) (c3+const1*0.07);}
        for(i=0;i<145;i++)
        {
        	if((c4[i]+z[i])>0){c4[i]=-135-z[i];}
        	else if((c4[i]+z[i])<=0&&key==1){c4[i]=(float) (c4[i]+const1*0.07);}
        }
        
        
        gl.glLoadIdentity(); 
        mCubeRotation = mCubeRotation- 0.15f; 
        
        if(c20>0){c20=-40;}else if(c20<0&&key==1){c20=(float) (c20+const1*0.07);}
        if(c21>20){c21=-20;}else if(c21<20&&key==1){c21=(float) (c21+const1*0.07);}
        
      
        if(right==0.5)//moving charater to right
        {
        	if(tr<0)
        	{
        		tr=tr+0.08f;
        	}
        	
        }
        
        if(left==0.5)//moving character to left
        {
        	if(tr>-1.8f)
        	{
        		tr=tr-0.08f;
        	}
        	
        }
       
        
        if(hx-c20<5&&hx-c20>0)//7 is temporary ok
        {
        	if(left==0.5)
        	{
        		key=0;gameover=1;conss=0;
        	}
        }
        
        if(hx-(c21-20)<5&&hx-(c21-20)>0)//7 is temporary ok
        {
        	if(right==0.5)
        	{
        		key=0;gameover=1;conss=0;
        	}
        }
       
        
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU.gluPerspective(gl, 45.0f, (float)width / (float)height, 0.1f, 100.0f);
        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

	@Override
	public void onSurfaceCreated(GL10 gl,
			javax.microedition.khronos.egl.EGLConfig config) {
		// TODO Auto-generated method stub
		
	}
}

class Cube {
    
    private FloatBuffer mVertexBuffer;
    private FloatBuffer mColorBuffer;
    private ByteBuffer  mIndexBuffer;
        int i=0;
    private float vertices[] = new float[1000];
    private byte[] indices = new byte[1000];                        
    private float colors[] = new float[1000];
           public float d=1f;               
    		
   
    
                
    public Cube(float x,float y,float z,float l,float b,float h,float a,float b1,float c) {
    	
    	
    	a=a/255;b1=b1/255;c=c/255;
    	vertices[0]=x;vertices[1]=y;vertices[2]=z;
    	vertices[3]=x;vertices[4]=y;vertices[5]=z-b;
    	vertices[6]=x;vertices[7]=y-h;vertices[8]=z-b;
    	vertices[9]=x;vertices[10]=y-h;vertices[11]=z;
    	vertices[12]=x+l;vertices[13]=y;vertices[14]=z;
    	vertices[15]=x+l;vertices[16]=y;vertices[17]=z-b;
    	vertices[18]=x+l;vertices[19]=y-h;vertices[20]=z-b;
    	vertices[21]=x+l;vertices[22]=y-h;vertices[23]=z;
    	
    	indices[0]=0;indices[1]=1;indices[2]=2;
    	indices[3]=2;indices[4]=3;indices[5]=0;
    	indices[6]=0;indices[7]=1;indices[8]=5;
    	indices[9]=5;indices[10]=4;indices[11]=0;
    	indices[12]=1;indices[13]=2;indices[14]=5;
    	indices[15]=2;indices[16]=5;indices[17]=6;
    	indices[18]=2;indices[19]=6;indices[20]=3;
    	indices[21]=6;indices[22]=7;indices[23]=3;
    	indices[24]=0;indices[25]=4;indices[26]=7;
    	indices[27]=0;indices[28]=3;indices[29]=7;
    	indices[30]=4;indices[31]=5;indices[32]=6;
    	indices[33]=4;indices[34]=6;indices[35]=7;
    	
    	
    	colors[0]=a;colors[1]=b1;colors[2]=c;colors[3]=d;
    	colors[4]=a;colors[5]=b1;colors[6]=c;colors[7]=d;
    	colors[8]=a;colors[9]=b1;colors[10]=c;colors[11]=d;
    	colors[12]=a;colors[13]=b1;colors[14]=c;colors[15]=d;
    	colors[16]=a;colors[17]=b1;colors[18]=c;colors[19]=d;
    	colors[20]=a;colors[21]=b1;colors[22]=c;colors[23]=d;
    	colors[24]=a;colors[25]=b1;colors[26]=c;colors[27]=d;
    	colors[28]=a;colors[29]=b1;colors[302]=c;colors[31]=d;
    	
            ByteBuffer byteBuf = ByteBuffer.allocateDirect(vertices.length * 4);
            byteBuf.order(ByteOrder.nativeOrder());
            mVertexBuffer = byteBuf.asFloatBuffer();
            mVertexBuffer.put(vertices);
            mVertexBuffer.position(0);
                
            byteBuf = ByteBuffer.allocateDirect(colors.length * 4);
            byteBuf.order(ByteOrder.nativeOrder());
            mColorBuffer = byteBuf.asFloatBuffer();
            mColorBuffer.put(colors);
            mColorBuffer.position(0);
                
            mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
            mIndexBuffer.put(indices);
            mIndexBuffer.position(0);
    }

    public void draw(GL10 gl) {             
            gl.glFrontFace(GL10.GL_CW);
            
            gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mVertexBuffer);
            gl.glColorPointer(4, GL10.GL_FLOAT, 0, mColorBuffer);
            
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
             
            gl.glDrawElements(GL10.GL_TRIANGLES, 36, GL10.GL_UNSIGNED_BYTE, 
                            mIndexBuffer);
                
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}





