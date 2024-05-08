package com.wf.oecm.stcom.model;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OECMAddUser {
	private String username;
    private String email;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
