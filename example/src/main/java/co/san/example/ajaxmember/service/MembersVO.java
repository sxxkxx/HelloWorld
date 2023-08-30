package co.san.example.ajaxmember.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MembersVO {
	private int mbrId;
	private String mbrName;
	private String mbrPhone;
	private int mbrAge;
}
