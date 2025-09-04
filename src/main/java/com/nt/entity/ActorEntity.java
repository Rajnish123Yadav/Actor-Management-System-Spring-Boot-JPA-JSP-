package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.NonNull;

@Entity
@Table(name = "JPA_ACTRO_TAB1")
//@SQLDelete(sql="UPDATE JPA_ACTRO_TAB1 SET ACTIVE_SW='INACTIVE' WHERE actor_id=? AND updateCount=?")//For soft deletion
//@SQLRestriction("ACTIVE_SW <> 'INACTIVE'")//For making inactive records not participating in persistence operations
@SQLDelete(sql="UPDATE JPA_ACTRO_TAB1 SET ACTIVE_SW='INACTIVE' WHERE actor_id=? AND UPDATE_COUNT=?")
@SQLRestriction("ACTIVE_SW <> 'INACTIVE'")

public class ActorEntity {

    @Id
    @Column(name = "actor_id")
    @SequenceGenerator(name = "gen1", sequenceName = "AID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
    private Integer aid;

    
    @Column(length = 30, name = "ACTOR_NAME")
    @NonNull
    private String aname;

    
    @Column(length = 30, name = "ACTOR_ADDRS")
    @NonNull
    private String addrs;

   
    @Column(length = 30, name = "ACTOR_CATEGORY")
    @NonNull
    private String category;

    
    @Column(name = "ACTOR_FEE")
    @NonNull
    private Float fee;

    // Metadata fields
    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @Version
    @Column(name = "UPDATE_COUNT") // FIX: maps Java field to DB column
    private Integer updateCount;

    @Column(length = 30)
    private String createdBy;

    @Column(length = 30)
    private String updatedBy;

    @Column(length = 30, name = "ACTIVE_SW", nullable = false)
    private String activeSW = "active";
    
    //NoArgsConstructor.....
    public ActorEntity(){}
    
    
    //AllArgsConstructor........
    public ActorEntity(Integer aid, @NonNull String aname, @NonNull String addrs, @NonNull String category,
			@NonNull Float fee, LocalDateTime createdOn, LocalDateTime updatedOn, Integer updateCount, String createdBy,
			String updatedBy, String activeSW) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.addrs = addrs;
		this.category = category;
		this.fee = fee;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.updateCount = updateCount;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.activeSW = activeSW;
	}



//Getters and Setters method..............
	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getUpdateCount() {
		return updateCount;
	}

	public void setUpdateCount(Integer updateCount) {
		this.updateCount = updateCount;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getActiveSW() {
		return activeSW;
	}

	public void setActiveSW(String activeSW) {
		this.activeSW = activeSW;
	}


	@Override
	public String toString() {
		return "ActorEntity [aid=" + aid + ", aname=" + aname + ", addrs=" + addrs + ", category=" + category + ", fee="
				+ fee + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", updateCount=" + updateCount
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", activeSW=" + activeSW + "]";
	}
}

/*
 👉 My suggestion:

If you want quick features → Add Search + Restore Deleted + Dashboard.

If you want to impress in interview/project demo → Add Movie Section (relation with Actor).
 */
