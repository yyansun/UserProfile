package com.ruoyi.system.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysDept;

/**
 * 标签管理 数据层
 * 
 * @author ruoyi
 */
public interface SysDeptMapper
{
    /**
     * 查询标签管理数据
     * 
     * @param dept 标签信息
     * @return 标签信息集合
     */
    public List<SysDept> selectDeptList(SysDept dept);

    /**
     * 根据角色ID查询标签树信息
     * 
     * @param roleId 角色ID
     * @param deptCheckStrictly 标签树选择项是否关联显示
     * @return 选中标签列表
     */
    public List<Long> selectDeptListByRoleId(@Param("roleId") Long roleId, @Param("deptCheckStrictly") boolean deptCheckStrictly);

    /**
     * 根据标签ID查询信息
     * 
     * @param deptId 标签ID
     * @return 标签信息
     */
    public SysDept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子标签
     * 
     * @param deptId 标签ID
     * @return 标签列表
     */
    public List<SysDept> selectChildrenDeptById(Long deptId);

    /**
     * 根据ID查询所有子标签（正常状态）
     * 
     * @param deptId 标签ID
     * @return 子标签数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在子节点
     * 
     * @param deptId 标签ID
     * @return 结果
     */
    public int hasChildByDeptId(Long deptId);

    /**
     * 查询标签是否存在用户
     * 
     * @param deptId 标签ID
     * @return 结果
     */
    public int checkDeptExistUser(Long deptId);

    /**
     * 校验标签名称是否唯一
     * 
     * @param deptName 标签名称
     * @param parentId 父标签ID
     * @return 结果
     */
    public SysDept checkDeptNameUnique(@Param("deptName") String deptName, @Param("parentId") Long parentId);

    /**
     * 新增标签信息
     * 
     * @param dept 标签信息
     * @return 结果
     */
    public int insertDept(SysDept dept);

    /**
     * 修改标签信息
     * 
     * @param dept 标签信息
     * @return 结果
     */
    public int updateDept(SysDept dept);

    /**
     * 修改所在标签正常状态
     * 
     * @param deptIds 标签ID组
     */
    public void updateDeptStatusNormal(Long[] deptIds);

    /**
     * 修改子元素关系
     * 
     * @param depts 子元素
     * @return 结果
     */
    public int updateDeptChildren(@Param("depts") List<SysDept> depts);

    /**
     * 删除标签管理信息
     * 
     * @param deptId 标签ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);
}
