package it.geoframe.blogspot.brokergeo.data;

import oms3.annotations.Author;
import oms3.annotations.Description;
import oms3.annotations.Execute;
import oms3.annotations.In;
import oms3.annotations.Keywords;
import oms3.annotations.Label;
import oms3.annotations.License;
import oms3.annotations.Name;
import oms3.annotations.Status;
import oms3.annotations.Unit;

@Description("")

@Author(name = "Concetta D'Amato and Riccardo Rigon", contact = "concetta.damato@unitn.it")
@Keywords("Evapotranspiration")
@Label("")
@Name("")
@Status(Status.CERTIFIED)
@License("General Public License Version 3 (GPLv3)")
public class InputDataMain {
	
	/////////////////////////////////////////////
	// VARIABLES - INPUT
	/////////////////////////////////////////////
	
	@Description("Depth of the root.")
	@In
	@Unit("m")
	public double etaR;
	
	@Description("Depth of the Evaporation layer.")
	@In 
	@Unit("m")
	public double etaE;
	
	@Description("z coordinate read from grid NetCDF file.")
	@In
	@Unit("m")
	public double[] z;
	
	@Description("The stressed Transpiration from Prospero model.")
	@In
	@Unit("mm/s")
	public double transpiration;
	
	@Description("The stressed Evaporation from Prospero model.")
	@In
	@Unit("mm/s")
	public double evaporation;
	
	@Description("Vector containing the length of each control volume")
	@In
	@Unit("m")
	public double[] deltaZ;
	
	@Description("Evaporation from each control volume can be evaluated in different way"
			    + " Average method --> AverageMetod"
			    + " Weighted average method --> SizeWightedMetod")
	@In
	public String representativeEsModel;
	
	@Description("Transpiration from each control volume can be evaluated in different way"
			+ " Average method --> AverageMetod"
		    + " Weighted average method --> SizeWightedMetod"
			+ " Root weighted medod --> RootWightedMetod")
	@In
	public String representativeTsModel;
	
	@Description("The stress factor for each control volume")
	@In
	@Unit("-")
	public double[] g;
	
	
	@Description("Vector of G and n, for transpiration")
	@In
	@Unit("-")
	public double[] GnT;
	
	@Description("Vector of Initial Condition for root density")
	@In
	@Unit("-")
	public double[] rootIC;
	
	@Description("Vector of G and n, for evaporation")
	@In
	@Unit("-")
	public double[] GnE;


	private InputData input;
	

	
	@Execute
	public void process() throws Exception {
		System.out.print("\n\nStart InputDataMain");
		input = InputData.getInstance();
		
		input.etaR = etaR;
		input.etaE = etaE;
		input.z = z;
		input.transpiration = transpiration;
		input.evaporation = evaporation;
		input.deltaZ = deltaZ;
		input.representativeEsModel = representativeEsModel;
		input.representativeTsModel = representativeTsModel;
		input.g = g;
		input.GnT = GnT;
		input.GnE = GnE;
		input.rootIC = rootIC;
		
		System.out.print("\nEnd InputDataMain");
	}

}
	
