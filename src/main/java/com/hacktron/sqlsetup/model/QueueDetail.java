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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_seq")
    @SequenceGenerator(name = "detail_seq", initialValue = 1, sequenceName = "DETAIL_SEQ")
    private Long id;

    @JoinColumn(referencedColumnName = "id")
    private Queue queue;

    @Column
    private String queueId;
    @Column
    private Object message;
    @Column
    private String lastUpdatedBy;
    @Column
    private Date lastUpdated;

    public QueueDetail() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public void setMessage(Object message) {
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
