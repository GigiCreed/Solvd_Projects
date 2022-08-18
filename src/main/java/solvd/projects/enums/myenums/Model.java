package solvd.projects.enums.myenums;

public enum Model {
    AVENTADOR("Aventador"), E63("E63"),SIENNA("Sienna");

    private String modelName;
    Model(String modelName) {
        this.modelName=modelName;
    }

    public String getModelName() {
        return String.valueOf(modelName);
    }
}
