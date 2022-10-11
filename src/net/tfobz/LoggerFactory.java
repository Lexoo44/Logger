package net.tfobz;


public class LoggerFactory {
    private String path;
    public LoggerFactory() {
    }

    public Logger createLogger(String type, String message) {
        if (type == null && message == null) {
            return null;
        }
        String actuallType = checkType(type);
        switch (actuallType) {
            case "":
                return new Console(message);
            case "file":
                return new File(type, message);
            case "ip":
                return new UDP(type, message);
            default:
                throw new IllegalArgumentException("Unknowen Type");
        }
    }

    public String checkType(String type){
        java.io.File file= new java.io.File(type);
        this.path = file.getAbsolutePath();
        this.path = this.path.replace("\\" , "/");
        if(type == ""){
            return "";
        }
        if(type.contains(":")){
            return "ip";
        }else {
            return "file";
        }
    }

}
