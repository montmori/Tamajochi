package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import tamagotchi_klassen.Tamagotchi;

public class ActionBeenden implements ActionListener {
	
	private Tamagotchi t;
	
	public ActionBeenden(Tamagotchi t){
		this.t = t;
	}
	
	public void actionPerformed(ActionEvent e) {
		saveAndExit();		
	}

	private void saveAndExit(){
		
		
		FileOutputStream f;
		ObjectOutputStream o;
		try {
			
			f = new FileOutputStream("Save.ser");
			o = new ObjectOutputStream(f);
			o.writeObject(t);
			o.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}

}
