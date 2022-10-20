package br.com.qualqrum.api.enums;

public enum StatusSubscriptionEnum {
    OK("Aprovado"),
    AWAITING_PAYMENT("Aguardando pagamento"),
    WAITING_APPROVAL("Aguardando aprovação"),
    CANCELLATION_REQUEST("Solicitação de cancelamento"),
    CANCELED("Cancelado");

    private String description;

    StatusSubscriptionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
