package common.baseDao;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.dao
 * DateTime: 2017/12/20  10:28
 * Description:手动添加
 */
public interface IBaseRepository<T,ID extends Serializable> extends Repository<T,ID> {

    /**
     * 保存
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S save(S entity);

    /**
     * 存储集合
     * @param iterable
     * @param <S>
     * @return
     */
    <S extends T> S save(Iterable<ID> iterable);

    /**
     * 存储并刷新
     * @param entity
     * @param <S>
     * @return
     */
    <S extends T> S saveAndFlush(S entity);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    T findOne(ID id);

    /**
     * 根据条件查询返回对象
     * @param example
     * @return
     */
    T findOne(Example<T> example);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    T findByName(String name);

    /**
     * 查询全部
     * @return
     */
    List<T> findAll();

    /**
     * 查找全部并排序
     * @param sort
     * @return
     */
    List<T> findAll(Sort sort);

    /**
     *
     * @param iterable
     * @return
     */
    List<T> findAll(Iterable<ID> iterable);

    /**
     * 条件查询
     * @param example
     * @param <S>
     * @return
     */
    <S extends T> List<S> findAll(Example<S> example);

    /**
     * 多条件查询
     * @param example
     * @param sort
     * @param <S>
     * @return
     */
    <S extends T> List<S> findAll(Example example, Sort sort);

    /**
     * 查找分页
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);

    /**
     * 根据查询条件查询并分页
     * @param example
     * @param pageable
     * @param <S>
     * @return
     */
    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    /**
     * 查询条数
     * @return
     */
    Long count();

    /**
     * 按条件统计
     * @param example
     * @param <S>
     * @return
     */
    <S extends T> long count(Example<S> example);

    /**
     * 根据ID 判断对象是否存在
     * @param id
     * @return
     */
    boolean exists(ID id);

    /**
     * 根据条件判断是否存在
     * @param example
     * @param <S>
     * @return
     */
    <S extends T> boolean exists(Example<S> example);
    /**
     * 根据ID删除
     * @param id
     */
    void delete(ID id);

    /**
     * 删除
     * @param entity
     */
    void delete(T entity);

    /**
     * 删除集合中的实体
     * @param iterable
     */
    void delete(Iterable<? extends T> iterable);

    /**
     * 删除所有
     */
    void deleteAll();
}
