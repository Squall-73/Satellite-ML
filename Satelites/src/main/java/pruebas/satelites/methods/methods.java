package pruebas.satelites.methods;

import pruebas.satelites.entities.Satellite;

public class methods {

	private double[] kenobi={-500.0,-200.0};
	private double[] skywalker={100.0,-100.0};
	private double[] sato={500.0,100.0};

	public double[] getLocation(Satellite[] satellite){

		double shipx; //X position of ship

		double shipy; //Y position of ship

		double[] x= new double[satellite.length]; //X position array of satellites

		double[] y= new double[satellite.length]; //Y position array of satellites

		double[] d= new double[satellite.length]; //distance array from ships to satellites

		for (int i=0; i<satellite.length;i++) {

			d[i] = satellite[i].getDistance();

		switch (satellite[i].getName().toLowerCase()) {

			case "kenobi":
				x[i] = kenobi[0];
				y[i] = kenobi[1];
				break;

			case "skywalker":
				x[i] = skywalker[0];
				y[i] = skywalker[1];
				break;

			case "sato":
				x[i] = sato[0];
				y[i] = sato[1];
				break;
		}}

		shipx=(d[1]*d[1]-d[2]*d[2]+x[2]*x[2]-x[1]*x[1]+y[2]*y[2]-y[1]*y[1])/(2*(x[2]-x[1]));
		shipy=(d[1]*d[1]-d[3]*d[3]+x[3]*x[3]-x[1]*x[1]+y[3]*y[3]-y[1]*y[1]+2*shipx*(x[1]-x[3]))/(2*(x[2]-x[1]));

		double[] position={shipx,shipy};

		return position;

		}
	public String getMessage(Satellite[] satellite){

		String message="";

		//Search for the shortest message, the first message received, which has no gap at the beginning
		int shortestlength=satellite[0].getMessage().length;

		for(int i=1; i<satellite.length; i++){

			if(satellite[i].getMessage().length<shortestlength){

				shortestlength=satellite[i].getMessage().length;
			}else{}
		}

		//create a array of messages
		String[][] messagearray= new String[satellite.length][shortestlength];

		// cut messages, removing gap.

		for(int i=0;i<satellite.length;i++){

			for(int j=shortestlength; j>0; j--){

				messagearray[i][j]=satellite[i].getMessage()[j];
		}
		}

		///here i have the messages received from the satellites, without gap
		String[] a=messagearray[1];
		String[] b=messagearray[2];
		String[] c=messagearray[3];


		return message;
	}
}
