package es.santander.ascender.proyecto11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileProcesor implements IFileProcesor {

    @Override
    public String leerFile(String filePath) throws IOException {
        if (!Files.exists(Paths.get(filePath))) {
            throw new IOException("El archivo no existe: " + filePath);
        }
        
        return Files.readString(Paths.get(filePath));
    }

    @Override
    public String eliminarVocales(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[aeiouAEIOU]", "");
    }

    @Override
    public void escribirAFile(String filePath, String content) throws IOException {
        if (Paths.get(filePath).getParent() != null && 
            !Files.exists(Paths.get(filePath).getParent())) {
            throw new IOException("El directorio no existe: " + filePath);
        }

        if (Paths.get(filePath).getParent() != null && 
            !Files.isWritable(Paths.get(filePath).getParent())) {
            throw new IOException("No se puede escribir en el directorio: " + filePath);
        }

        Files.writeString(Paths.get(filePath), content);
    }
}
