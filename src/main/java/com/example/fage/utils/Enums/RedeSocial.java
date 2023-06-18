package com.example.fage.utils.Enums;

public enum RedeSocial {
    FACEBOOK(1, "Facebook"),
    INSTAGRAM(2, "Instagram"),
    TIKTOK(3, "TikTok"),
    WHATSAPP(4, "WhatsApp"),
    LINKEDIN(5, "LinkedIn"),
    TWITTER(6, "Twitter");
    private final int id;
    private final String descricao;

    private RedeSocial(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}