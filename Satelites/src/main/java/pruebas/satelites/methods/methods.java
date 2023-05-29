package pruebas.satelites.methods;

import pruebas.satelites.entities.Satellite;
import pruebas.satelites.exceptions.NotEnoughInformationException;

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

		shipx=(Math.pow(d[1],2)-Math.pow(d[2],2)+Math.pow(x[2],2)-Math.pow(x[1],2)+Math.pow(y[2],2)-Math.pow(y[1],2))/(2*(x[2]-x[1]));
		shipy=(Math.pow(d[1],2)-Math.pow(d[3],2)+Math.pow(x[3],2)-Math.pow(x[1],2)+Math.pow(y[3],2)-Math.pow(y[1],2)+2*shipx*(x[1]-x[3]))/(2*(x[2]-x[1]));

		double[] position={shipx,shipy};

		return position;

		}
	public String getMessage(Satellite[] satellite) throws NotEnoughInformationException{

		String message="";

		//Search for the shortest message, the first message received, which has no gap at the beginning
		int shortestlength=satellite[0].getMessage().length;

		for(int i=1; i<satellite.length; i++){

			if(satellite[i].getMessage().length<shortestlength){

				shortestlength=satellite[i].getMessage().length;
			}
		}

		//create a array of messages
		String[][] messagearray= new String[satellite.length][shortestlength];

		// cut messages, removing gap.

		for(int i=0;i<satellite.length;i++){

			for(int j=shortestlength; j>0; j--){

				messagearray[i][j]=satellite[i].getMessage()[j];
		}
		}

		for(int i=0;i<messagearray[0].length;i++){

				String st="";

			for (int j=0; j<messagearray.length;j++){

				if(messagearray[j][i]!="" && st==""){

					st=messagearray[j][i];

				} else if (messagearray[j][i]!="" && messagearray[j][i]!=st) {

					throw new NotEnoughInformationException("couldn't decipher message ");

				}

			}

			message=message + st + " ";
		}

		//Remove last " " at the end of the message

		message = message.trim().replaceAll("\\s+$", "");

		return message;
	}
}
