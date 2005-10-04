package net.sourceforge.fenixedu.presentationTier.backBeans.manager.degree;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import net.sourceforge.fenixedu.applicationTier.Filtro.exception.FenixFilterException;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceException;
import net.sourceforge.fenixedu.dataTransferObject.InfoCampus;
import net.sourceforge.fenixedu.dataTransferObject.InfoDegreeCurricularPlan;
import net.sourceforge.fenixedu.dataTransferObject.InfoExecutionYear;
import net.sourceforge.fenixedu.domain.degree.DegreeType;
import net.sourceforge.fenixedu.presentationTier.Action.sop.utils.ServiceUtils;
import net.sourceforge.fenixedu.presentationTier.backBeans.base.FenixBackingBean;
import net.sourceforge.fenixedu.util.Data;

/**
 * 
 * @author - Shezad Anavarali (shezad@ist.utl.pt)
 * 
 */
public class CreateExecutionDegreesForExecutionYear extends FenixBackingBean {

    private String chosenDegreeType;

    private Integer[] choosenDegreeCurricularPlansIDs;

    // private UISelectMany selectMany;

    private UISelectItems degreeCurricularPlansSelectItems;

    private Integer choosenExecutionYearID;

    private String campus;

    private Boolean temporaryExamMap;

    private Integer lessonSeason1BeginDay;

    private Integer lessonSeason1BeginMonth;

    private Integer lessonSeason1BeginYear;

    private Integer lessonSeason1EndDay;

    private Integer lessonSeason1EndMonth;

    private Integer lessonSeason1EndYear;

    private Integer lessonSeason2BeginDay;

    private Integer lessonSeason2BeginMonth;

    private Integer lessonSeason2BeginYear;

    private Integer lessonSeason2EndDay;

    private Integer lessonSeason2EndMonth;

    private Integer lessonSeason2EndYear;

    private Integer examsSeason1BeginDay;

    private Integer examsSeason1BeginMonth;

    private Integer examsSeason1BeginYear;

    private Integer examsSeason1EndDay;

    private Integer examsSeason1EndMonth;

    private Integer examsSeason1EndYear;

    private Integer examsSeason2BeginDay;

    private Integer examsSeason2BeginMonth;

    private Integer examsSeason2BeginYear;

    private Integer examsSeason2EndDay;

    private Integer examsSeason2EndMonth;

    private Integer examsSeason2EndYear;

    public CreateExecutionDegreesForExecutionYear() {
        super();
        // this.selectMany = (UISelectMany)
        // FacesContext.getCurrentInstance().getApplication()
        // .createComponent(UISelectMany.COMPONENT_TYPE);

    }

    public List getDegreeTypes() {

        List<SelectItem> degreeTypes = new ArrayList<SelectItem>(DegreeType.values().length);
        for (DegreeType degreeType : DegreeType.values()) {
            degreeTypes.add(new SelectItem(degreeType.name(), degreeType.name()));
        }

        return degreeTypes;
    }

    public String getChosenDegreeType() {
        return chosenDegreeType;
    }

    public void setChosenDegreeType(String chosenDegreeType) {
        this.chosenDegreeType = chosenDegreeType;
    }

    public UISelectItems getDegreeCurricularPlansSelectItems() throws FenixFilterException,
            FenixServiceException {

        if (this.degreeCurricularPlansSelectItems == null) {

            DegreeType degreeType = (getChosenDegreeType() != null) ? DegreeType
                    .valueOf(getChosenDegreeType()) : null;
            Object[] args = { degreeType };
            List degreeCurricularPlans = (List) ServiceUtils.executeService(getUserView(),
                    "ReadActiveDegreeCurricularPlansByDegreeType", args);

            List<SelectItem> items = new ArrayList<SelectItem>(degreeCurricularPlans.size());
            for (InfoDegreeCurricularPlan degreeCurricularPlan : (List<InfoDegreeCurricularPlan>) degreeCurricularPlans) {
                String label = degreeCurricularPlan.getInfoDegree().getNome() + " - "
                        + degreeCurricularPlan.getName();
                items.add(new SelectItem(degreeCurricularPlan.getIdInternal(), label));
            }
            
            this.degreeCurricularPlansSelectItems = new UISelectItems();
            this.degreeCurricularPlansSelectItems.setValue(items);
        }
        
        return this.degreeCurricularPlansSelectItems;
    }

    public void setDegreeCurricularPlansSelectItems(UISelectItems degreeCurricularPlansSelectItems) {

        this.degreeCurricularPlansSelectItems = degreeCurricularPlansSelectItems;
    }

    public List getExecutionYears() throws FenixFilterException, FenixServiceException {

        List<InfoExecutionYear> executionYears = (List<InfoExecutionYear>) ServiceUtils.executeService(
                getUserView(), "ReadNotClosedExecutionYears", null);

        List<SelectItem> result = new ArrayList<SelectItem>(executionYears.size());
        for (InfoExecutionYear executionYear : executionYears) {
            result.add(new SelectItem(executionYear.getIdInternal(), executionYear.getYear()));
        }

        setChoosenExecutionYearID(executionYears.get(executionYears.size() - 1).getIdInternal());

        return result;
    }

    public List getAllCampus() throws FenixFilterException, FenixServiceException {

        List<InfoCampus> allCampus = (List<InfoCampus>) ServiceUtils.executeService(getUserView(),
                "ReadAllCampus", null);

        List<SelectItem> result = new ArrayList<SelectItem>(allCampus.size());
        for (InfoCampus campus : allCampus) {
            result.add(new SelectItem(campus.getName(), campus.getName()));
        }

        return result;
    }

    public String createExecutionDegrees() throws FenixFilterException, FenixServiceException {

        Calendar lessonSeason1BeginDate = Calendar.getInstance();
        lessonSeason1BeginDate.set(getLessonSeason1BeginYear(), getLessonSeason1BeginMonth(),
                getLessonSeason1BeginDay());

        Calendar lessonSeason1EndDate = Calendar.getInstance();
        lessonSeason1EndDate.set(getLessonSeason1EndYear(), getLessonSeason1EndMonth(),
                getLessonSeason1EndDay());

        Calendar lessonSeason2BeginDate = Calendar.getInstance();
        lessonSeason2BeginDate.set(getLessonSeason2BeginYear(), getLessonSeason2BeginMonth(),
                getLessonSeason2BeginDay());

        Calendar lessonSeason2EndDate = Calendar.getInstance();
        lessonSeason2EndDate.set(getLessonSeason2EndYear(), getLessonSeason2EndMonth(),
                getLessonSeason2EndDay());

        Calendar examsSeason1BeginDate = Calendar.getInstance();
        examsSeason1BeginDate.set(getExamsSeason1BeginYear(), getExamsSeason1BeginMonth(),
                getExamsSeason1BeginDay());

        Calendar examsSeason1EndDate = Calendar.getInstance();
        examsSeason1EndDate.set(getExamsSeason1EndYear(), getExamsSeason1EndMonth(),
                getExamsSeason1EndDay());

        Calendar examsSeason2BeginDate = Calendar.getInstance();
        examsSeason2BeginDate.set(getExamsSeason2BeginYear(), getExamsSeason2BeginMonth(),
                getExamsSeason2BeginDay());

        Calendar examsSeason2EndDate = Calendar.getInstance();
        examsSeason2EndDate.set(getExamsSeason2EndYear(), getExamsSeason2EndMonth(),
                getExamsSeason2EndDay());

        Object[] args = { getChoosenDegreeCurricularPlansIDs(), getChoosenExecutionYearID(),
                getCampus(), getTemporaryExamMap(), lessonSeason1BeginDate, lessonSeason1EndDate,
                lessonSeason2BeginDate, lessonSeason2EndDate, examsSeason1BeginDate,
                examsSeason1EndDate, examsSeason2BeginDate, examsSeason2EndDate };

        ServiceUtils.executeService(getUserView(), "CreateExecutionDegreesForExecutionYear", args);

        return "success";
    }

    public List getDays() {
        return Data.getMonthDaysSelectItems();
    }

    public List getMonths() {
        return Data.getMonthsSelectItems();
    }

    public List getYears() {
        return Data.getExpirationYearsSelectItems();
    }

    public Integer[] getChoosenDegreeCurricularPlansIDs() {
        return choosenDegreeCurricularPlansIDs;
    }

    public void setChoosenDegreeCurricularPlansIDs(Integer[] choosenDegreeCurricularPlansIDs) {
        this.choosenDegreeCurricularPlansIDs = choosenDegreeCurricularPlansIDs;
    }

    public Integer getChoosenExecutionYearID() {
        return choosenExecutionYearID;
    }

    public void setChoosenExecutionYearID(Integer choosenExecutionYearID) {
        this.choosenExecutionYearID = choosenExecutionYearID;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public Integer getExamsSeason1BeginDay() {
        return examsSeason1BeginDay;
    }

    public void setExamsSeason1BeginDay(Integer examsSeason1BeginDay) {
        this.examsSeason1BeginDay = examsSeason1BeginDay;
    }

    public Integer getExamsSeason1BeginMonth() {
        return examsSeason1BeginMonth;
    }

    public void setExamsSeason1BeginMonth(Integer examsSeason1BeginMonth) {
        this.examsSeason1BeginMonth = examsSeason1BeginMonth;
    }

    public Integer getExamsSeason1BeginYear() {
        return examsSeason1BeginYear;
    }

    public void setExamsSeason1BeginYear(Integer examsSeason1BeginYear) {
        this.examsSeason1BeginYear = examsSeason1BeginYear;
    }

    public Integer getExamsSeason1EndDay() {
        return examsSeason1EndDay;
    }

    public void setExamsSeason1EndDay(Integer examsSeason1EndDay) {
        this.examsSeason1EndDay = examsSeason1EndDay;
    }

    public Integer getExamsSeason1EndMonth() {
        return examsSeason1EndMonth;
    }

    public void setExamsSeason1EndMonth(Integer examsSeason1EndMonth) {
        this.examsSeason1EndMonth = examsSeason1EndMonth;
    }

    public Integer getExamsSeason1EndYear() {
        return examsSeason1EndYear;
    }

    public void setExamsSeason1EndYear(Integer examsSeason1EndYear) {
        this.examsSeason1EndYear = examsSeason1EndYear;
    }

    public Integer getExamsSeason2BeginDay() {
        return examsSeason2BeginDay;
    }

    public void setExamsSeason2BeginDay(Integer examsSeason2BeginDay) {
        this.examsSeason2BeginDay = examsSeason2BeginDay;
    }

    public Integer getExamsSeason2BeginMonth() {
        return examsSeason2BeginMonth;
    }

    public void setExamsSeason2BeginMonth(Integer examsSeason2BeginMonth) {
        this.examsSeason2BeginMonth = examsSeason2BeginMonth;
    }

    public Integer getExamsSeason2BeginYear() {
        return examsSeason2BeginYear;
    }

    public void setExamsSeason2BeginYear(Integer examsSeason2BeginYear) {
        this.examsSeason2BeginYear = examsSeason2BeginYear;
    }

    public Integer getExamsSeason2EndDay() {
        return examsSeason2EndDay;
    }

    public void setExamsSeason2EndDay(Integer examsSeason2EndDay) {
        this.examsSeason2EndDay = examsSeason2EndDay;
    }

    public Integer getExamsSeason2EndMonth() {
        return examsSeason2EndMonth;
    }

    public void setExamsSeason2EndMonth(Integer examsSeason2EndMonth) {
        this.examsSeason2EndMonth = examsSeason2EndMonth;
    }

    public Integer getExamsSeason2EndYear() {
        return examsSeason2EndYear;
    }

    public void setExamsSeason2EndYear(Integer examsSeason2EndYear) {
        this.examsSeason2EndYear = examsSeason2EndYear;
    }

    public Integer getLessonSeason1BeginDay() {
        return lessonSeason1BeginDay;
    }

    public void setLessonSeason1BeginDay(Integer lessonSeason1BeginDay) {
        this.lessonSeason1BeginDay = lessonSeason1BeginDay;
    }

    public Integer getLessonSeason1BeginMonth() {
        return lessonSeason1BeginMonth;
    }

    public void setLessonSeason1BeginMonth(Integer lessonSeason1BeginMonth) {
        this.lessonSeason1BeginMonth = lessonSeason1BeginMonth;
    }

    public Integer getLessonSeason1BeginYear() {
        return lessonSeason1BeginYear;
    }

    public void setLessonSeason1BeginYear(Integer lessonSeason1BeginYear) {
        this.lessonSeason1BeginYear = lessonSeason1BeginYear;
    }

    public Integer getLessonSeason1EndDay() {
        return lessonSeason1EndDay;
    }

    public void setLessonSeason1EndDay(Integer lessonSeason1EndDay) {
        this.lessonSeason1EndDay = lessonSeason1EndDay;
    }

    public Integer getLessonSeason1EndMonth() {
        return lessonSeason1EndMonth;
    }

    public void setLessonSeason1EndMonth(Integer lessonSeason1EndMonth) {
        this.lessonSeason1EndMonth = lessonSeason1EndMonth;
    }

    public Integer getLessonSeason1EndYear() {
        return lessonSeason1EndYear;
    }

    public void setLessonSeason1EndYear(Integer lessonSeason1EndYear) {
        this.lessonSeason1EndYear = lessonSeason1EndYear;
    }

    public Integer getLessonSeason2BeginDay() {
        return lessonSeason2BeginDay;
    }

    public void setLessonSeason2BeginDay(Integer lessonSeason2BeginDay) {
        this.lessonSeason2BeginDay = lessonSeason2BeginDay;
    }

    public Integer getLessonSeason2BeginMonth() {
        return lessonSeason2BeginMonth;
    }

    public void setLessonSeason2BeginMonth(Integer lessonSeason2BeginMonth) {
        this.lessonSeason2BeginMonth = lessonSeason2BeginMonth;
    }

    public Integer getLessonSeason2BeginYear() {
        return lessonSeason2BeginYear;
    }

    public void setLessonSeason2BeginYear(Integer lessonSeason2BeginYear) {
        this.lessonSeason2BeginYear = lessonSeason2BeginYear;
    }

    public Integer getLessonSeason2EndDay() {
        return lessonSeason2EndDay;
    }

    public void setLessonSeason2EndDay(Integer lessonSeason2EndDay) {
        this.lessonSeason2EndDay = lessonSeason2EndDay;
    }

    public Integer getLessonSeason2EndMonth() {
        return lessonSeason2EndMonth;
    }

    public void setLessonSeason2EndMonth(Integer lessonSeason2EndMonth) {
        this.lessonSeason2EndMonth = lessonSeason2EndMonth;
    }

    public Integer getLessonSeason2EndYear() {
        return lessonSeason2EndYear;
    }

    public void setLessonSeason2EndYear(Integer lessonSeason2EndYear) {
        this.lessonSeason2EndYear = lessonSeason2EndYear;
    }

    public Boolean getTemporaryExamMap() {
        return temporaryExamMap;
    }

    public void setTemporaryExamMap(Boolean temporaryExamMap) {
        this.temporaryExamMap = temporaryExamMap;
    }

    // public UISelectMany getSelectMany() {
    //        
    // try {
    // UISelectItems selectItems = new UISelectItems();
    // selectItems.setValue(getDegreeCurricularPlans());
    // selectItems.setId("dcps");
    // this.selectMany.getChildren().clear();
    // this.selectMany.getChildren().add(selectItems);
    // } catch (FenixFilterException e) {
    // e.printStackTrace();
    // } catch (FenixServiceException e) {
    // e.printStackTrace();
    // }
    //        
    // return selectMany;
    // }
    //
    // public void setSelectMany(UISelectMany selectMany) {
    // this.selectMany = selectMany;
    // }

}
