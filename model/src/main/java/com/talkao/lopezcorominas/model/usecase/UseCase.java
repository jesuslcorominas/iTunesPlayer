package com.talkao.lopezcorominas.model.usecase;

import com.talkao.lopezcorominas.commons.GetCallback;

/**
 * @author Jesús López Corominas
 */
public interface UseCase<I, O> {

    void execute(I input, GetCallback<O> callback);
}
