package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import models.Animales;
import models.Usuarios;
import ui.LoginView;
import ui.RegisterView;
import utils.Almacen;

class RegisterViewTest {

	void crearAlmacen()
	{
		Usuarios doctor1 = new Usuarios("doctor1", "doctor");
		Usuarios doctor2 = new Usuarios("doctor2", "doctor");

		Almacen.Users.add(doctor1);
		Almacen.Users.add(doctor2);

		doctor1.addMascota(new Animales("Toby", 12345, "perro", "pastor aleman", 10));
		doctor1.addMascota(new Animales("Misifu", 23456, "gato", "persa", 2));
		doctor1.addMascota(new Animales("gatubela", 34567, "elefante", "gris", 4000));


		doctor2.addMascota(new Animales("firulais", 45678, "perro", "pastor aleman", 7));
		doctor2.addMascota(new Animales("perico", 56789, "pajaro", "canario", 0.5));
		doctor2.addMascota(new Animales("grabie", 90123, "caballo", "pura sangre", 1));
	}
	
	@Test
	void testChkRegister() {
		crearAlmacen();
		RegisterView window = new RegisterView(new JFrame());
		
		assertTrue(window.checkRegister("doctor", "doctor", "doctor3"));
		assertFalse(window.checkRegister("doctor", "doctor", "doctor1"));
		assertFalse(window.checkRegister("doctor", "doctor", ""));
		assertFalse(window.checkRegister("", "", "doctor4"));
		assertFalse(window.checkRegister("doc", "dac", "doctor5"));
		
	}

}
