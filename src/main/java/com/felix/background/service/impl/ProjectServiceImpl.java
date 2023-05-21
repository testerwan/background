package com.felix.background.service.impl;

import com.felix.background.entity.Project;
import com.felix.background.mapper.ProjectMapper;
import com.felix.background.service.ProjectService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Felix
 * @since 2023-05-21
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {

}
