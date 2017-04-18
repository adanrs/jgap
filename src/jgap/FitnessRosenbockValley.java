/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgap;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class FitnessRosenbockValley extends FitnessFunction {

	private static final long serialVersionUID = -6347033124326483842L;
	private static final long dosALa36Menos1=new Double(Math.pow(2, 36)).longValue()-1;

	private int largo;
  
	public FitnessRosenbockValley(int l) {
	  largo=l;
	}

	public double evaluate(IChromosome cacho) {
	  
	  double puntaje=0;
	  
	  Double x=extractXFromChromosome(cacho);
	  Double y=extractYFromChromosome(cacho);
	  if (x>2) return -10;
	  if (y>2) return -10;
	  
	  puntaje=100*Math.pow((y-x*x),2)+Math.pow((1-x),2);
	  
	  return puntaje;
	  
	}
  
	public Double extractXFromChromosome(IChromosome cacho)
	{
	  double x=0;
	  
	  long zx=0;
	  
	  for (int i=0;i<largo;i++)
		  zx=zx+new Double(Math.pow(new Double(2*(Integer)cacho.getGenes()[i].getAllele()),new Double(largo-1-i))).longValue();
	  zx-=1;

	  
	  x=(double)-2+(double)zx*(double)4/(double)(dosALa36Menos1);

	  return x;
	}	

	public Double extractYFromChromosome(IChromosome cacho)
	{
	  double y=0;
	  
	  long zy=0;
	  
	  for (int i=largo;i<2*largo;i++)
		  zy=zy+new Double(Math.pow(new Double(2*(Integer)cacho.getGenes()[i].getAllele()),new Double(largo*2-1-i))).longValue();
	  zy-=1;
	  
	  y=(double)-2+(double)zy*(double)4/(double)(dosALa36Menos1);
	  return y;
	}
  
}
