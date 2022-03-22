package br.com.danepic.kafkakeycloakapi.resource.type;

public enum SpecimenStatus {
    AVAILABLE("available"),
    UNAVAILABLE("unavailable"),
    UNSATISFACTORY("unsatisfactory"),
    ENTERED_IN_ERROR("entered-in-error	");

    private String type;

    SpecimenStatus(String type) {
        this.type = type;
    }
}
