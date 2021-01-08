package org.crazycoder.builderdesignpattern;

public class PC {
	
	private final String ram;
	private final String vga;
	private final String processor;
	private final String motherboard;
	
	public PC(Builder builder) {
		this.ram =builder.ram;
		this.vga =builder.vga;
		this.processor =builder.processor;
		this.motherboard =builder.motherboard;
	}
	
	static class Builder{
		private  String ram;
		private  String vga;
		private  String processor;
		private  String motherboard;
		
		public PC build() {
			return new PC(this);
		}
		
		public Builder() {	}
		
		public Builder ram(String ram) {
			this.ram = ram;
			return this;
		}
		
		public Builder vga(String vga) {
			this.vga = vga;
			return this;
		}
		
		public Builder processor(String processor) {
			this.processor = processor;
			return this;
		}
		
		public Builder motherboard(String motherboard) {
			this.motherboard = motherboard;
			return this;
		}
	}

	@Override
	public String toString() {
		return "PC [ram=" + ram + ", vga=" + vga + ", processor=" + processor + ", motherboard=" + motherboard + "]";
	}
	
	
}
