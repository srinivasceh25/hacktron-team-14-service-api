package com.hacktron.sqlsetup.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Sneha.G
 */
@Entity
@Table(name = "QueueDetail")
public class QueueDetail implements Serializable {
    private static final long serialVersionUID=102;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String queueId;
    @Column
    private String message;
    @Column
    private String lastUpdatedBy;
    @Column
    private Date lastUpdated;

    public QueueDetail() {
    }

    public void setId(Long id) {
        this.id = id;
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
