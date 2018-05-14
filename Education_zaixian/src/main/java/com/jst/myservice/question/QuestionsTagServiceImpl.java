package com.jst.myservice.question;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jst.mapper.question.QuestionsTagMapper;
import com.jst.model.QuestionsTag;
import com.jst.ztree.ZtreeNode;

@Service
public class QuestionsTagServiceImpl implements QuestionsTagService{
    
	@Autowired
	private QuestionsTagMapper questionsTagMapper;
	
	@Override
	public List<ZtreeNode> listAll() {
		List<QuestionsTag> list=questionsTagMapper.listAll();
		List<ZtreeNode> notes=new ArrayList<ZtreeNode>();
		for (int i = 0; i < list.size(); i++) {
			 QuestionsTag qTag=list.get(i);
			 ZtreeNode ztreeNode=new ZtreeNode();
			 ztreeNode.setId(qTag.getQuestions_tag_id());
			 ztreeNode.setName(qTag.getQuestions_tag_name());
			 ztreeNode.setPid(qTag.getParent_id());
			 notes.add(ztreeNode);
		}
		return notes;
	}

	@Override
	public void save(QuestionsTag questionsTag) {
		questionsTagMapper.save(questionsTag);
		
	}

	@Override
	public void delete(int qtid) {
		questionsTagMapper.delete(qtid);
		
	}

	@Override
	public QuestionsTag getById(int qtid) {
		QuestionsTag questionsTag=questionsTagMapper.getById(qtid);
		return questionsTag;
	}

	@Override
	public void update(QuestionsTag questionsTag) {
		questionsTagMapper.update(questionsTag);
		
	}

}
