/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jgap;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class App {

	private static final int LARGO=36;
	private static final int MAX_ALLOWED_EVOLUTIONS = 100;


  public static void main(String[] args) throws Exception{
  
	  	long tim=System.currentTimeMillis();
	  	
	    Configuration conf = new DefaultConfiguration();
	    conf.setPreservFittestIndividual(true);
	    FitnessFunction myFunc =new FitnessRosenbockValley(LARGO);
	    conf.setFitnessFunction(myFunc);
	    Gene[] sampleGenes = new Gene[LARGO*2];
	    for (int i = 0; i < LARGO*2; i++) {
	      sampleGenes[i] = new IntegerGene(conf, 0,1);
	    }
	    IChromosome sampleChromosome = new Chromosome(conf, sampleGenes);
	    conf.setSampleChromosome(sampleChromosome);
	    conf.setPopulationSize(50);
	    Genotype population;
	    population = Genotype.randomInitialGenotype(conf);
	        
	    for (int i = 0; i < MAX_ALLOWED_EVOLUTIONS; i++) {
	      population.evolve();

	      //Descomentar si se quiere toda la salida....
//	      IChromosome bestSolutionSoFar = population.getFittestChromosome();
//		  double x=((FitnessRosenbockValley)myFunc).extractXFromChromosome(bestSolutionSoFar);
//		  double y=((FitnessRosenbockValley)myFunc).extractYFromChromosome(bestSolutionSoFar);
//	      System.out.println("Generación " + (i+1) + " \t- Mejor individuo con fitnes " + bestSolutionSoFar.getFitnessValue() + "\tx="+x+"\ty="+y);
	    }

	    System.out.println("Solución encontrada en " + (double)(System.currentTimeMillis()-tim)/(double)1000 + " segundos.");

	    IChromosome bestSolutionSoFar = population.getFittestChromosome();
	    System.out.println("La mejor solución tiene un fitness de " +
	                       bestSolutionSoFar.getFitnessValue());
	    System.out.println("El individuo resultó ser: ");

	    double x=((FitnessRosenbockValley)myFunc).extractXFromChromosome(bestSolutionSoFar);
	    double y=((FitnessRosenbockValley)myFunc).extractYFromChromosome(bestSolutionSoFar);
        System.out.println("x="+x);
        System.out.println("y="+y);
  }
}
