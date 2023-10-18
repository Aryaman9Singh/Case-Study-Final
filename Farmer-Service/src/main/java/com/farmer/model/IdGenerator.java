package com.farmer.model;

import org.springframework.data.mongodb.core.mapping.Document;



@Document("cropsequence")
public class IdGenerator {
	
	private  String seqid;
	private  int sequence;
	public String getSeqid() {
		return seqid;
	}
	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}
