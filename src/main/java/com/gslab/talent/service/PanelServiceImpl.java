package com.gslab.talent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.Panel;
import com.gslab.talent.repository.PanelRepository;

@Service
public class PanelServiceImpl implements PanelService{
	
	@Autowired
	PanelRepository panelRepoObj;
	
	@Override
	public void createNewPanel(Panel panel) {
		panelRepoObj.save(panel);
	}

}
