package com.ruoyi.app.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.app.mapper.ReviewMapper;
import com.ruoyi.app.domain.Review;
import com.ruoyi.app.service.IReviewService;
import com.ruoyi.common.core.text.Convert;

/**
 * 评论管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class ReviewServiceImpl implements IReviewService 
{
    @Autowired
    private ReviewMapper reviewMapper;

    /**
     * 查询评论管理
     * 
     * @param id 评论管理ID
     * @return 评论管理
     */
    @Override
    public Review selectReviewById(Long id)
    {
        return reviewMapper.selectReviewById(id);
    }

    /**
     * 查询评论管理列表
     * 
     * @param review 评论管理
     * @return 评论管理
     */
    @Override
    public List<Review> selectReviewList(Review review)
    {
        return reviewMapper.selectReviewList(review);
    }

    /**
     * 新增评论管理
     * 
     * @param review 评论管理
     * @return 结果
     */
    @Override
    public int insertReview(Review review)
    {
        review.setCreateTime(DateUtils.getNowDate());
        return reviewMapper.insertReview(review);
    }

    /**
     * 修改评论管理
     * 
     * @param review 评论管理
     * @return 结果
     */
    @Override
    public int updateReview(Review review)
    {
        return reviewMapper.updateReview(review);
    }

    /**
     * 删除评论管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteReviewByIds(String ids)
    {
        return reviewMapper.deleteReviewByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除评论管理信息
     * 
     * @param id 评论管理ID
     * @return 结果
     */
    @Override
    public int deleteReviewById(Long id)
    {
        return reviewMapper.deleteReviewById(id);
    }
}
