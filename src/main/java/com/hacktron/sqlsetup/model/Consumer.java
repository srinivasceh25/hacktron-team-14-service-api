package com.hacktron.sqlsetup.model;

/**
 * @author Sneha.G
 */
public class Consumer {
    private static final long serialVersionUID=102;
    private Long id;
    private String messageId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
