package mz.org.csaude.mentoring.model.form;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Objects;




import mz.org.csaude.mentoring.base.dto.BaseEntityDTO;
import mz.org.csaude.mentoring.base.model.BaseModel;
import mz.org.csaude.mentoring.dao.form.FormDAOImpl;
import mz.org.csaude.mentoring.dto.form.FormDTO;
import mz.org.csaude.mentoring.model.partner.Partner;
import mz.org.csaude.mentoring.model.programmaticArea.ProgrammaticArea;


@DatabaseTable(tableName = Form.TABLE_NAME, daoClass = FormDAOImpl.class)

public class Form extends BaseModel {

    public static final String TABLE_NAME = "form";
    public static final String COLUMN_NAME= "name";
    public static final String COLUMN_CODE = "code";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_PROGRAMMATIC_AREA= "programmatic_area_type_id";
    public static final String COLUMN_TARGET_PATIENT = "target_patient";
    public static final String COLUMN_TARGET_FILE = "target_file";
    public static final String COLUMN_PARTNER = "partner_id";

    @DatabaseField(columnName = COLUMN_NAME)
    private String name;

    @DatabaseField(columnName = COLUMN_CODE)
    private String code;

    @DatabaseField(columnName = COLUMN_DESCRIPTION)
    private String description;

    @DatabaseField(columnName = COLUMN_PROGRAMMATIC_AREA, canBeNull = false, foreign = true, foreignAutoRefresh = true )
    private ProgrammaticArea programmaticArea;

    @DatabaseField(columnName = COLUMN_TARGET_PATIENT)
    private int targetPatient;

    @DatabaseField(columnName = COLUMN_TARGET_FILE)
    private int targetFile;

    @DatabaseField(columnName = COLUMN_PARTNER, canBeNull = false, foreign = true, foreignAutoRefresh = true )
    private Partner partner;

    public Form() {
    }

    public Form(FormDTO formDTO) {
        super(formDTO);
        this.setCode(formDTO.getCode());
        this.setDescription(formDTO.getDescription());
        this.setName(formDTO.getName());
        this.setTargetFile(formDTO.getTargetFile());
        this.setTargetPatient(formDTO.getTargetPatient());
        if (formDTO.getPartner() != null) this.setPartner(new Partner(formDTO.getPartner()));
        if (formDTO.getProgrammaticArea() != null) this.setProgrammaticArea(new ProgrammaticArea(formDTO.getProgrammaticArea()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgrammaticArea getProgrammaticArea() {
        return programmaticArea;
    }

    public void setProgrammaticArea(ProgrammaticArea programmaticArea) {
        this.programmaticArea = programmaticArea;
    }

    public int getTargetPatient() {
        return targetPatient;
    }

    public void setTargetPatient(int targetPatient) {
        this.targetPatient = targetPatient;
    }

    public int getTargetFile() {
        return targetFile;
    }

    public void setTargetFile(int targetFile) {
        this.targetFile = targetFile;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Form)) return false;
        if (!super.equals(o)) return false;
        Form form = (Form) o;
        return Objects.equals(code, form.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code);
    }
}
