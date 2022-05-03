/*
 * GNU GPL v3 License
 *
 * Copyright 2016 Marialaura Bancheri
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package brokergeo;
//import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import it.geoframe.blogspot.brokergeo.solver.*;
import it.geoframe.blogspot.brokergeo.data.*;
import it.geoframe.blogpsot.netcdf.monodimensionalproblemtimedependent.ReadNetCDFRichardsLysimeterGrid1D;
/**
 * Test the Broker module.
 * @author Concetta D'Amato
 */

public class TestBrokerGEOOneFlux {

	@Test
	public void Test() throws Exception {

		String pathGrid =  "resources\\Input\\Grid_NetCDF\\GridLysRoot.nc";
		ReadNetCDFRichardsLysimeterGrid1D readNetCDF = new ReadNetCDFRichardsLysimeterGrid1D();		

		double transpiration = 65;
		double[] g = {0.49853778058804915, 0.49853778058804915, 0.7751738855516915, 0.9332516598166297, 0.8542127726841605, 1.0, 1.0, 1.0, 1.0, 1.0};
		double[] GnT = {0.9453297897565602,8};
		double etaR = -0.8;
		
		
		ETsBrokerOneFluxSolverMain ETsBrokerSolver = new ETsBrokerOneFluxSolverMain();  
		InputDataMain Input = new InputDataMain();
		
		readNetCDF.richardsGridFilename = pathGrid;
		
		readNetCDF.read();
		Input.representativeTsModel = "RootWeightedMethod"; //AverageWaterWeightedMethod, SizeWaterWeightedMetod, RootWaterWeightedMethod
																//AverageWeightedMethod, SizeWeightedMetod, RootWeightedMethod

		Input.z = readNetCDF.z;
		Input.rootIC = readNetCDF.rootIC; 
		Input.etaR = etaR;
		Input.deltaZ = readNetCDF.spaceDelta;
		Input.transpiration = transpiration;
		Input.g = g;
		Input.GnT = GnT;
		ETsBrokerSolver.useWaterStress = false; //Quando si usano i metodi semplici dovrebbe essere in false
		
		Input.process();
		ETsBrokerSolver.solve();
	}
}

