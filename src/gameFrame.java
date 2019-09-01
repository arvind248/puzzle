import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class address
{
		int row,col;
			
		address()
		{
			row=0;col=0;
		}		
}		



public class gameFrame extends JFrame implements ActionListener 
{
	static final int n=4;
	static Button b[][]=new Button[n][n];
	
	Button SelcBtn;	

	gameFrame()		
	{
            setVisible(true);
            setSize(400,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(n,n));		
		

		LinkedHashSet <Integer> set=new LinkedHashSet <Integer>();
																		
					Random r = new Random()	;
						while(set.size()<15)
						{				
						set.add((r.nextInt(15)+1));
						}	


					Iterator<Integer> itr=set.iterator();
					int randomNnumber[] = new int[16] ;
					int i=0;
				while(itr.hasNext())
				{  
				    randomNnumber[i]= itr.next();
				    i++;  
				}
	






		for( i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				 int k=randomNnumber[j*4+i];

				b[i][j]=new Button(""+k);
				add(b[i][j]);
				b[i][j].addActionListener(this);
			}		
		}
		
		b[3][3].setLabel("");
		SelcBtn= b[3][3];
		//add(b[3][3]);
		//SelcBtn.addActionListener(this);
		//SelcBtn.setLabel("test");	
					
	}

        
   
	public void actionPerformed(ActionEvent ae)
	{
		Button PrBtn=(Button)ae.getSource();	
		//PrssBtn.setLabel("0");
				
		if(!(PrBtn.getLabel().equals("")))
		{
			boolean yes=isAdjacent(SelcBtn,PrBtn);
			
			if(yes==true)
			{	
			String tem;
			tem=SelcBtn.getLabel();	
			SelcBtn.setLabel(PrBtn.getLabel());
			PrBtn.setLabel(tem);
			SelcBtn=PrBtn;	 
			}
			

			
		
		}						
		
	}

	static boolean  isAdjacent(Button selc,Button Prss)
	{
		int ip,is,jp,js;
		address selcBAdd=new address();
		address PrssBAdd=new address();
		
			selcBAdd=findRowCol(selc);
			PrssBAdd=findRowCol(Prss);

			if(PrssBAdd.col==selcBAdd.col)
			{
				
					ip=PrssBAdd.row;
					is=selcBAdd.row;
	
					if(ip==0)
					{
						if(ip+1==is)
						return true;
						else
						return false;
 		
					}
					else if (ip==n)
					{
						if(ip-1==is)
						return true;
						else
						return false;
					}	
					else if((ip>0)&&(ip<n))
					{
						if((ip+1==is)||(ip-1==is))
						return true;
						else
						return false;	
					}
					else
					return false;
					
					
							
			
				
			}	
			else if(PrssBAdd.row==selcBAdd.row)
			{
						
					jp=PrssBAdd.col;
					js=selcBAdd.col; 	
		
					if(jp==0)
					{
						if(jp+1==js)
						return true;
						else
						return false;
 					}
					else if (jp==n)
					{
						if(jp-1==js)
						return true;
						else
						return false;
					}	
					else if((jp>0)&&(jp<n))
					{
						if((jp+1==js)||(jp-1==js))
						return true;
						else
						return false;	
					}		
					else
					return false;				
				
			}
			else
			return false;				
	}



	static address findRowCol(Button  val)
	{
			int i,j;
			address selcBAdd=new address();
			for(i=0;i<n;i++)
			{
				for(j=0;j<n;j++)
				{
						if(b[i][j]==val)
						{
							
							selcBAdd.row=i;
							selcBAdd.col=j;	 
						}
				}	
			}
		return selcBAdd;	
	}	
}


