package util;

public class Validators {

	public static boolean verificarStringVazia(String valor){
		if (valor == null || valor.trim().isEmpty()){
			return true;
		}
		return false;
	}
}
