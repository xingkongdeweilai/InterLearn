package edu.cqut.llj.pojo;

import javax.persistence.*;

@Table(name = "word_and_user")
public class WordAndUser {
    @Id
    private Integer id;

    private Integer relationship;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "word_id")
    private Integer wordId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return relationship
     */
    public Integer getRelationship() {
        return relationship;
    }

    /**
     * @param relationship
     */
    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return word_id
     */
    public Integer getWordId() {
        return wordId;
    }

    /**
     * @param wordId
     */
    public void setWordId(Integer wordId) {
        this.wordId = wordId;
    }
}