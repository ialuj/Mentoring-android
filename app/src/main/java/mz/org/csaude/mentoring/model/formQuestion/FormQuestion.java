package mz.org.csaude.mentoring.model.formQuestion;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;



import mz.org.csaude.mentoring.base.dto.BaseEntityDTO;
import mz.org.csaude.mentoring.base.model.BaseModel;
import mz.org.csaude.mentoring.dao.formQuestion.FormQuestionDAImpl;
import mz.org.csaude.mentoring.dto.form.FormDTO;
import mz.org.csaude.mentoring.dto.form.FormQuestionDTO;
import mz.org.csaude.mentoring.model.answer.Answer;
import mz.org.csaude.mentoring.model.evaluationType.EvaluationType;
import mz.org.csaude.mentoring.model.form.Form;
import mz.org.csaude.mentoring.model.question.Question;
import mz.org.csaude.mentoring.model.responseType.ResponseType;


@DatabaseTable(tableName = FormQuestion.TABLE_NAME, daoClass = FormQuestionDAImpl.class)

public class FormQuestion extends BaseModel {

    public static final String TABLE_NAME = "form_question";
    public static final String COLUMN_FORM = "form_id";

    public static final String COLUMN_QUESTION = "question_id";
    public static final String COLUMN_EVALUATION_TYPE = "evaluation_type_id";
    public static final String COLUMN_RESPONSE_TYPE = "response_type_id";

    public static final String COLUMN_MANDATORY = "mandatory";

    public static final String COLUMN_SEQUENCE = "sequence";

    public static final String COLUMN_APPLICABLE = "applicable";

    @DatabaseField(columnName = COLUMN_FORM, canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Form form;

    @DatabaseField(columnName = COLUMN_QUESTION, canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private Question question;
    @DatabaseField(columnName = COLUMN_EVALUATION_TYPE, canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private EvaluationType evaluationType;
    @DatabaseField(columnName = COLUMN_RESPONSE_TYPE, canBeNull = false, foreign = true, foreignAutoRefresh = true)
    private ResponseType responseType;

    @DatabaseField(columnName = COLUMN_MANDATORY)
    private boolean mandatory;

    private Answer answer;

    @DatabaseField(columnName = COLUMN_SEQUENCE)
    private Integer sequence;

    @DatabaseField(columnName = COLUMN_APPLICABLE)
    private Boolean applicable;

    public FormQuestion() {
    }

    public FormQuestion(FormQuestionDTO formQuestionDTO) {
        super(formQuestionDTO);
        this.setSequence(formQuestionDTO.getSequence());
        if(formQuestionDTO.getQuestion()!=null)  this.setQuestion(new Question(formQuestionDTO.getQuestion()));
        if(formQuestionDTO.getEvaluationType()!=null) this.setEvaluationType(new EvaluationType(formQuestionDTO.getEvaluationType()));
        if(formQuestionDTO.getResponseType()!=null) this.setResponseType(new ResponseType(formQuestionDTO.getResponseType()));
        if(formQuestionDTO.getForm()!=null) this.setForm(new Form(formQuestionDTO.getForm()));
    }

    public Form getForm() {
        return form;
    }

    public Question getQuestion() {
        return question;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public Integer getSequence() {
        return sequence;
    }

    public Boolean getApplicable() {
        return applicable;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public EvaluationType getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(EvaluationType evaluationType) {
        this.evaluationType = evaluationType;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public void setApplicable(Boolean applicable) {
        this.applicable = applicable;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
