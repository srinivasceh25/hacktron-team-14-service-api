package com.hacktron.sqlsetup.model;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Sneha.G
 */
@Entity
@Table(name = "QueueDetail")
@EntityListeners(AuditingEntityListener.class)
public class QueueDetail implements Serializable {
    private static final long serialVersionUID=102;

    @Id
    private Long id;

    @Column
    private Long queueId;
    @Column
    private String message;
    @Column(columnDefinition = "Sneha")
    private String lastUpdatedBy;

    private Date lastUpdated;

    public QueueDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = Long.valueOf(2);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "QueueDetail{" +
                "id=" + id +
                ", queueId='" + queueId + '\'' +
                ", message=" + message +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdated=" + lastUpdated +
                '}';
    }
}
