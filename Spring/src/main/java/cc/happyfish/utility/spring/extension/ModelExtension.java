package cc.happyfish.utility.spring.extension;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 作者:汪阳 <br>
 * 部门:计算机应用开发室 <br>
 * 联系:0553-8399022  <br>
 * 时间:2017/4/26 <br>
 * 说明:
 */
@MappedSuperclass
public class ModelExtension implements Serializable {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    /**
     * 备注
     */
    @Column(columnDefinition = "TEXT")
    private String remark;

    /**
     * 更新人编号
     */
    @Column(name = "updated_id")
    private String updatedId;//用户id

    /**
     * 更新日期
     */
    @Column(name = "updated_date")
    @DateTimeFormat(pattern = ControllerExtension.DATETIME_PATTERN)
    @JsonFormat(pattern = ControllerExtension.DATETIME_PATTERN)
    private LocalDateTime updatedDate = LocalDateTime.now();

    /**
     * 是否已经删除
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted")
    private IsDeleted isDeleted = IsDeleted.No;

    /**
     * 是否删除
     */
    public enum IsDeleted {
        Yes,
        No
    }
}