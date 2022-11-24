package com.proyecto.spring.model;

public enum Plataforma {
	Atari("2600"), //tratarEnum, hacer comparativa (foto en recortes)
	Do("3DO"),
	TresDs("3DS"),
	Dc("DC"),
	Ds("DS"),
	Gb("GB"),
	Gba("GBA"),
	Gc("GC"),
	Gen("GEN"),
	Gg("GG"),
	N64("N64"),
	Nes("NES"),
	Ng("NG"),
	Pc("PC"),
	Pcfx("PCFX"),
	Ps("PS"),
	Ps2("PS2"),
	Ps3("PS3"),
	Ps4("PS4"),
	Psp("PSP"),
	Psv("PSV"),
	Sat("SAT"),
	Scd("SCD"),
	Snes("SNES"),
	Tg16("TG16"),
	Wii("Wii"),
	Wiiu("WiiU"),
	Ws("WS"),
	X360("X 360"),
	XB("X B"),
	XOne("X One"),
	Defecto("No tiene plataforma valida");
	
	private String plataforma;
	
	private Plataforma () {
		
	}

	private Plataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public String getPlataforma() {
		return this.plataforma;
	}
	
	public String toString() {
		return this.name();
	}
}
