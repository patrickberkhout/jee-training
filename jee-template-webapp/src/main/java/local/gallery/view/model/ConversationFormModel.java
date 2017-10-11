package local.gallery.view.model;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ConversationFormModel implements Serializable {

	@Inject
	Conversation conversation;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Integer integerAttribute = 1;

	public Integer getIntegerAttribute() {
		return integerAttribute;
	}

	public void setIntegerAttribute(Integer integerAttribute) {
		this.integerAttribute = integerAttribute;
	}

	public String startConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
			integerAttribute = 1;
		}
		return "";
	}

	public boolean getIsConversationTransient() {
		return conversation.isTransient() ;
	}

	public void increaseByOne() {
		this.integerAttribute++;
	}

	public void endConversation() {
		integerAttribute = 1;
		conversation.end();
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
}
