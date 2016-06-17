package model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
//import java.nio.channels.SelectionKey;
import java.sql.SQLException;
import java.util.Observable;

import javax.imageio.ImageIO;

import contract.IModel;


/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public class Model extends Observable implements IModel {

	/** The message. */
	private String message ="";
	 private Image img;
	 
	 char[] ch = null;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.message = "";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *          the new message
	 */
	private void setMessage(final String message) {
		this.message = message;
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMessage(final String key) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setMessage(daoHelloWorld.find(key).getMessage());
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	public String GetChar()
	{
		String mot = "CESI ?";
		ch = message.toCharArray();
		//split = new StrToChar(message);
		return mot;
		
		
	}
	
	public Image sld(int cpt) throws IOException
	{
		//ch = message.toCharArray(); 
		for(int i = 0; i<240;i++){
			System.out.println("Char : " + ch[i]);
			System.out.println("cpt : " + cpt);
		}

		switch(ch[cpt])
		{
		case 'U': 
			 img = ImageIO.read(new File("sprite/lorann_l.png"));
			
			 break;
			
		case 'O':
			img = ImageIO.read(new File("sprite/crystal_ball.png"));
			break;
			
		case 'M':
			img = ImageIO.read(new File("sprite/gate_closed.png"));
			break;
			
		case '|':
			img = ImageIO.read(new File("sprite/vertical_bone.png"));
			break;
			
		case '-':
			 img = ImageIO.read(new File("sprite/horizontal_bone.png"));
			
			break;
		case 'c':
			img = ImageIO.read(new File("sprite/bone.png"));
			break;
			
		case 'E':
			img = ImageIO.read(new File("sprite/monster_1.png"));
			break;
			
		case 'e':
			img = ImageIO.read(new File("sprite/monster_2.png"));			
			break;
			
		case 'B':
			img = ImageIO.read(new File("sprite/monster_3.png"));			
			break;
			
		case 'b':
			img = ImageIO.read(new File("sprite/monster_4.png"));			
			break;
			
		case '$':
			img = ImageIO.read(new File("sprite/purse.png"));			
			break;
			
		case ':':
			img = ImageIO.read(new File("sprite/noimage.jpg"));			
			break;
			
		default :
			img = ImageIO.read(new File("sprite/noimage.jpg"));
			break;
		
		}
		
		//Image img = ImageIO.read(new File("sprite/lorann_l.png"));
		
		
		
		return img ;
		
	}
}